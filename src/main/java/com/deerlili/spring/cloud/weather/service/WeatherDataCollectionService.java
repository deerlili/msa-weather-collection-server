package com.deerlili.spring.cloud.weather.service;

public interface WeatherDataCollectionService {

    /**
     * 根据城市Id同步天气
     * @param cityId
     */
    void syncDataByCityId(String cityId);

}
