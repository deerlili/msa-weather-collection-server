package com.deerlili.spring.cloud.weather.service.impl;

import com.deerlili.spring.cloud.weather.entity.WeatherResponse;
import com.deerlili.spring.cloud.weather.service.WeatherDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author deerlili
 * @Classname WeatherDataServiceImpl
 * @Description WeatherDataSerive 实现.
 * @Date 2020-07-08 09:40
 * @Version V1.0
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherDataService.class);

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    //这里设置10秒做演示，正常半个小时（1800）或者其他的时间
    private static final long TIME_OUT = 1800L;


    @Autowired
    private RestTemplate restTemplate;//注入Rest client客户端

    @Autowired
    private StringRedisTemplate stringRedisTemplate; //是对redisApi做的封装

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return doGetWeather(uri);
    }

    /**
     * 根据cityId来同步天气
     *
     * @param cityId
     */
    @Override
    public void syncDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }


    private WeatherResponse doGetWeather(String uri) {

        String strBody = null;
        WeatherResponse weatherResponse = null;
        ObjectMapper objectMapper = new ObjectMapper(); //jackson

        String key = uri;
        // redis 是一个kv对，天气数据是uri是唯一的，
        // 每一个uri是一个城市，可以用uri作为key
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        if (stringRedisTemplate.hasKey(key)) {
            // 先查缓存，缓存中有取缓存的数
            logger.info("Redis hash data");
            strBody = ops.get(key);
        } else {
            // 缓存中没有，去调用第三方的接口获取数据
            logger.info("Redis no hash data");
            ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);

            if (forEntity.getStatusCodeValue() == 200) {
                strBody = forEntity.getBody();
            }
            // 数据写入缓存中,设置超时间时间和单位
            ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
        }

        try {
            // json反序列化
            weatherResponse = objectMapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error!", e);
        }

        return weatherResponse;
    }

    /**
     * 把天气数据放入缓存中
     * @param uri
     */
    private void  saveWeatherData(String uri) {
        String strBody = null;
        String key = uri;
        // redis 是一个kv对，天气数据是uri是唯一的，用uri作为key
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        // 调用第三方的接口获取数据
        ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);

        if (forEntity.getStatusCodeValue() == 200) {
            strBody = forEntity.getBody();
        }
        // 数据写入缓存中,设置超时间时间和单位
        ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);

    }

}
