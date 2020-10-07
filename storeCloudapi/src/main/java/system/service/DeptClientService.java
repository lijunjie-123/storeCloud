package system.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import system.dept.model.Dept;

import java.util.List;

/**
 * Created by wangxy on 20/10/5.
 */
@FeignClient(value = "MICROSERIVCECLOUD-DEPT")
public interface DeptClientService {

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept);


    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") String id);


    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list();
}
