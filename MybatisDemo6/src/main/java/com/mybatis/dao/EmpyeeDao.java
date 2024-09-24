package com.mybatis.dao;


import com.mybatis.domain.Dept;
import com.mybatis.domain.Empyee;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface EmpyeeDao {

    /**
     * 查询所有用户
     * @return
     */
    public List<Empyee> findAll();


    /**
     * 根据部门ID查询部门员工
     */
    public List<Empyee> findByDeptId(Integer deptid);

    /**
     * 根据工作ID查询工种员工
     */
    public List<Empyee> findByJobId(Integer jobid);
}
