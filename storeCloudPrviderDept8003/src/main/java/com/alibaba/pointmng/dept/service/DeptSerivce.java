package com.alibaba.pointmng.dept.service;

import system.dept.model.Dept;

import java.util.List;

/**
 * Created by wangxy on 19/12/26.
 */
public interface DeptSerivce {
    /**
     * 在这里为什么不和dao层的方法名相同,
     * 因为在写Controller层这些方法名更加符合Rest的风格 * */
    public boolean add(Dept dept)throws Exception;


    public Dept get(String id)throws Exception;


    public List<Dept> list()throws Exception;
}
