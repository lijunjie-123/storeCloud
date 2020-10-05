package com.alibaba.pointmng.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import system.dept.model.Dept;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangxy on 20/1/12.
 */
@RestController
public class DeptControllerConsumer {

    //访问服务提供方的url
    private static final String REST_URL_PREFIX = "http://MICROSERIVCECLOUD-DEPT/pointmng/dept";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
        /*
        * 之前这样调用。现在这里是消费者不用Serivce层 * return serivce.add();
        */
        /*
        * 这里的restTemplate.postForObject(REST请求的地址(提供者的地址),请
        * HTTP响应转换被转换是的对象)
        */
        return restTemplate.postForObject(REST_URL_PREFIX + "/add" , dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") String id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/get/" + id, Dept.class);
    }

    //销毁端调用服务端的发现
    @RequestMapping(value ="/consumer/dept/discovery")
    public Object discoverys() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }

    @SuppressWarnings("unchecked") //压制警告
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/list" , List.class);
    }

}
