package com.mybatis.dao;


import com.mybatis.domain.Empyee;
import com.mybatis.domain.EmpyeeDeptJob;

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
     * 查询所有雇员并带有部门和工种信息
     * @return
     */
    public List<EmpyeeDeptJob> findAllEmpyee();


}
