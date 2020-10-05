package com.alibaba.pointmng.dept.controller;

import com.alibaba.pointmng.dept.service.DeptSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import system.EurekaInstance;
import system.dept.model.Dept;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangxy on 20/1/5.
 */

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptSerivce deptSerivceImpl;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {

        //进行盘点Eureka有多少个微服务 ,后续工作有很多个为服务如订单等等
        List<String> services = discoveryClient.getServices();
        System.out.println("-----" + services);
        //在盘点的微服务中进行找这个微服务的MICROSERIVCECLOUD
        List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERIVCECLOUD-DEPT");
        List<EurekaInstance> list = new ArrayList<EurekaInstance>();
        EurekaInstance eurekaInstance = new EurekaInstance();
        for (ServiceInstance serviceInstance : instances) {
            eurekaInstance.setServiceId(serviceInstance.getServiceId());
            eurekaInstance.setHost(serviceInstance.getHost());
            eurekaInstance.setPort(serviceInstance.getPort());
            eurekaInstance.setUrl(serviceInstance.getUri());
            list.add(eurekaInstance);
            //打印出现这个微服务的 id 主机名称 端口 地址
            System.out.println(
                    serviceInstance.getServiceId()+"\t"+ serviceInstance.getHost()+"\t"+ serviceInstance.getPort()+"\t"+ serviceInstance.getUri()
            );
        }
        return this.discoveryClient;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) throws Exception {
       return deptSerivceImpl.add(dept);
     }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
        public Dept get(@PathVariable("id") String id) throws Exception {
        return deptSerivceImpl.get(id);
     }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Dept> list() throws Exception {
      return deptSerivceImpl.list();
     }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public int delete(@PathVariable("id") String id) throws Exception {
        return deptSerivceImpl.deleteById(id);
    }

}
