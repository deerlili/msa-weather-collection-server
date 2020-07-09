package com.deerlili.spring.cloud.weather.config;

import com.deerlili.spring.cloud.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author deerlili
 * @Classname QuartzConfiguration
 * @Description TODO
 * @Date 2020/7/8 20:42
 * @Version V1.0
 */
@Configuration
public class QuartzConfiguration {

    private static final int TIME = 1800; // 跟新频率

    // JobDetail
    @Bean
    public JobDetail weatherDataSyncJobJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class)
                .withIdentity("weatherDataSyncJob") // 给job定义一个名称
                .storeDurably()
                .build();
    }
    // Trigger
    @Bean
    public Trigger weatherDataSyncJobTrigger() {

        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(TIME) // 每隔两秒执行，这里测试
                .repeatForever();

        return TriggerBuilder
                .newTrigger()
                .forJob(weatherDataSyncJobJobDetail())
                .withIdentity("weatherDataSyncJobTrigger") // 给Trigger定义一个名称
                .withSchedule(scheduleBuilder)
                .build();
    }

}
