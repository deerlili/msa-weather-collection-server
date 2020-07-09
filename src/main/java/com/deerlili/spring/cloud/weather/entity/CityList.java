package com.deerlili.spring.cloud.weather.entity;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author deerlili
 * @Classname CityList
 * @Description TODO
 * @Date 2020/7/8 22:03
 * @Version V1.0
 */

@XmlRootElement(name = "c") //解析xml，d是元素的名称
@XmlAccessorType(XmlAccessType.FIELD) //访问的类型,通过字段
@Data
public class CityList {
    @XmlElement(name = "d") //元素
    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
