package com.deerlili.spring.cloud.weather.controller;


import com.deerlili.spring.cloud.weather.service.CityDataService;
import com.deerlili.spring.cloud.weather.service.WeatherReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/report")
@Api(value = "天气预报报表接口",description = "天气预报报表接口")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;
    @Autowired
    private CityDataService cityDataService;


    @GetMapping("/cityid/{cityid}")
    @ApiOperation(value = "根据城市id获取", notes = "根据城市id获取")
    public ModelAndView getReportByCityId(@PathVariable("cityid") String cityid,Model model) throws Exception {
        model.addAttribute("title","deerlili天气预报");
        model.addAttribute("cityId",cityid);
        model.addAttribute("cityList", cityDataService.listCity());
        model.addAttribute("report",weatherReportService.getDataByCityId(cityid));
        return new ModelAndView("weather/report","reportModel",model);
    }

}
