package com.alibaba.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangxy on 20/10/4.
 */
@Configuration
public class CustomRule {

    @Bean
    public IRule isCustomRule(){
        return new CustomRandomRule();
    }
}
