package com.deerlili.spring.cloud.weather.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(value = "test",description = "test")
public class TestController {


    @GetMapping
    @ApiOperation(value = "test", notes = "test")
    public String test() {
        return "test";
    }

}
