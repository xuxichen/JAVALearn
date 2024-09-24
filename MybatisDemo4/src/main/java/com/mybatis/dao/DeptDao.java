package com.mybatis.dao;

import com.mybatis.domain.Dept;

import java.util.List;

public interface DeptDao {
    /**
     * 查询所有部门,同时获取各个部门的人员信息
     * @return
     */
    public List<Dept> findAll();

}
