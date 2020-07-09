package com.deerlili.spring.cloud.weather.service;

import com.deerlili.spring.cloud.weather.entity.City;

import java.util.List;

public interface CityDataService {

    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
