package com.alibaba.pointmng.configBean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wangxy on 20/1/12.
 */
@Configuration
public class ConfigBean {

    /*
    * 复习:|@Bean相对于在Spring的配置文件中的<bean id="perosnSerivce" * class="com.ch.xxx.perosnSerivceImp">
    *
    * @Bean public PerosnSerivce getPerosnSerivce() { return new * PerosnSerivce(); }
    */
    @Bean
    @LoadBalanced //自带轮询机制
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

  /*  @Bean //自己定义的算法，会覆盖之前默认的轮询机制
    public IRule myRule(){
        return new RandomRule();
    }*/
}
