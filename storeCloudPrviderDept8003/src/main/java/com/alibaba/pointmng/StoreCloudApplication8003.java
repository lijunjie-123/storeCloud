package com.alibaba.pointmng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by wangxy on 20/8/22.
 */
@MapperScan(basePackages = "com.alibaba.pointmng.dept.dao")
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //服务发现
public class StoreCloudApplication8003 {
    public static void main(String[] args) {
        SpringApplication.run(StoreCloudApplication8003.class,args);
    }
}
