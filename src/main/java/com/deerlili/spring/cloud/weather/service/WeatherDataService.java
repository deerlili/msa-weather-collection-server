package com.deerlili.spring.cloud.weather.service;

import com.deerlili.spring.cloud.weather.entity.WeatherResponse;

public interface WeatherDataService {
    /**
     * 根据城市ID查询天气数据
     *
     * @param cityId
     * @return
     * */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根根据城市名称查询天气数据
     *
     * @param cityName
     * @return
     * */
    WeatherResponse getDataByCityName(String cityName);

    /**
     * 根据cityId来同步天气
     * @param cityId
     */
    void syncDataByCityId(String cityId);

}
