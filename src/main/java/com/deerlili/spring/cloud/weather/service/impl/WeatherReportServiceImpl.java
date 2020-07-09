package com.deerlili.spring.cloud.weather.service.impl;

import com.deerlili.spring.cloud.weather.entity.Weather;
import com.deerlili.spring.cloud.weather.service.WeatherDataService;
import com.deerlili.spring.cloud.weather.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author deerlili
 * @Classname WeatherReportServiceImpl
 * @Description 天气预报接口实现
 * @Date 2020-07-09 10:20
 * @Version V1.0
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        return weatherDataService.getDataByCityId(cityId).getData();
    }
}
