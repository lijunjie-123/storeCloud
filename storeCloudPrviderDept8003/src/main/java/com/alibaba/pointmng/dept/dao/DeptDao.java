package com.alibaba.pointmng.dept.dao;

import org.apache.ibatis.annotations.Mapper;
import system.dept.model.Dept;

import java.util.List;

/**
 * Created by wangxy on 19/12/26.
 */
@Mapper
public interface DeptDao {

    //添加
    public boolean addDept(Dept dept)throws Exception;

    //查询单个
    public Dept findById(String id)throws Exception;

    //查询所有
    public List<Dept> findAll()throws Exception;

    public void deleteById(String id);
}
