package com.alibaba.pointmng;

/**
 * Created by wangxy on 20/1/12.
 */
//本微服务消费者的主启动的类

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
//@RibbonClient(name = "MICROSERIVCECLOUD-DEPT")
@EnableFeignClients(basePackages = {"system"})
@ComponentScan("system")
public class DeptConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeignApplication.class,args);
    }
}
