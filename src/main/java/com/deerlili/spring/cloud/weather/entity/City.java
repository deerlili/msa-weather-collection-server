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
@XmlRootElement(name = "d") //解析xml，d是元素的名称
@XmlAccessorType(XmlAccessType.FIELD) //访问的类型,通过字段
public class City {
    @XmlAttribute(name = "d1") //元素的属性
    private String cityId;
    @XmlAttribute(name = "d2")
    private String cityName;
    @XmlAttribute(name = "d3")
    private String cityCode;
    @XmlAttribute(name = "d4")
    private String province;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
