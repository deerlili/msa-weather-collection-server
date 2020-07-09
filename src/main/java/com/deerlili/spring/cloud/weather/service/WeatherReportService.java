package com.deerlili.spring.cloud.weather.service;

import com.deerlili.spring.cloud.weather.entity.Weather;

/**
 * @author deerlili
 * @Classname WeatherReportService
 * @Description 天气预报服务
 * @Date 2020-07-09 10:17
 * @Version V1.0
 */
public interface WeatherReportService {
    /**
     * 根据城市ID查询天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
