package com.mybatis.dao;

import com.mybatis.domain.Job;

import java.util.List;

public interface JobDao {

    /**
     * 查询所有工种，同时获取各个工种下的所有人员信息
     * @return
     */
    public List<Job> findAll();
}
