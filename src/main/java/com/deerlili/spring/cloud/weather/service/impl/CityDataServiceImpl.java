package com.deerlili.spring.cloud.weather.service.impl;

import com.deerlili.spring.cloud.weather.entity.City;
import com.deerlili.spring.cloud.weather.entity.CityList;
import com.deerlili.spring.cloud.weather.service.CityDataService;
import com.deerlili.spring.cloud.weather.util.XmlBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author deerlili
 * @Classname CityDataServiceImpl
 * @Description TODO
 * @Date 2020/7/8 22:16
 * @Version V1.0
 */
@Service
public class CityDataServiceImpl implements CityDataService {
    /**
     * 获取城市列表
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<City> listCity() throws Exception {
        // 读取XML文件
        Resource resource = new ClassPathResource("citylist.xml");
        // 读取输入流
        BufferedReader bf = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));

        StringBuffer sb = new StringBuffer();
        String line = "";

        while ((line = bf.readLine()) != null) {
            sb.append(line);
        }

        bf.close();

        // XML转为Java对象
        CityList cityList = (CityList)XmlBuilder.xmlStrToObject(CityList.class, sb.toString());
        return cityList.getCityList();
    }
}
