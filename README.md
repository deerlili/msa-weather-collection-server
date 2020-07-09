# micro-weather-basic
# 技术
  1. SpringBoot
  2. Gradle
  3. Lombok
  4. HttpClient(RestTemple)
  5. Redis
  6. Quartz
 # 实现
  1. 获取天气数据
  2. 用户请求返回天气数据
  ```
    数据来源第三方API
    强依赖：导致其他系统调用接口有比较大的延时
    数据的搬运工-中介服务
    免费的接口存在风险
        请求次数
        并发数对第三方系统有影响
    解决办法：使用Redis来提升整个的应用的并发能力
   ```

  4. 使用redis提升应用的并发访问能力
  5. 添加Quartz，定时调度
  ```
    定时调度去获取第三方数据
    保存到redis中，在redis中摄像数据超时时间
    
   ```
  3. 展示
  ```
# Thymeleaf
是一个java语言的模板引擎，面向后端的模板引擎
# Bootstrap
应用不是很强的定制化的界面基本都可以
    
   ```
    
  
