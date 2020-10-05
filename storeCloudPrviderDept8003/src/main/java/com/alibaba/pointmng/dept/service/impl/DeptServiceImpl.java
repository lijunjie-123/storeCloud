package com.alibaba.pointmng.dept.service.impl;

import com.alibaba.pointmng.dept.dao.DeptDao;
import com.alibaba.pointmng.dept.service.DeptSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dept.model.Dept;

import java.util.List;

/**
 * Created by wangxy on 19/12/26.
 */
@Service
public class DeptServiceImpl implements DeptSerivce {
/*

    @Resource
    private DeptMapper deptMapper;
*/

   @Autowired
    private DeptDao deptDao;

    @Override
    public boolean add(Dept dept) throws Exception {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(String id) throws Exception {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> list() throws Exception {
        return deptDao.findAll();
    }
}
