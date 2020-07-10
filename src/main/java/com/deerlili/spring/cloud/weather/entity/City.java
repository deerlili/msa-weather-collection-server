package com.deerlili.spring.cloud.weather.entity;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * @author deerlili
 * @Classname City
 * @Description TODO
 * @Date 2020/7/8 21:56
 * @Version V1.0
 */

@Data
public class City {

    private String cityId;

    private String cityName;

    private String cityCode;

    private String province;


}
