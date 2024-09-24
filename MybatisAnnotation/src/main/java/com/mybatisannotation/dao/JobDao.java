package com.mybatisannotation.dao;

import com.mybatisannotation.domain.Dept;
import com.mybatisannotation.domain.Job;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
@CacheNamespace(blocking = true)
public interface JobDao {

    /**
     * 查询所有工种，同时获取各个工种下的所有人员信息
     * @return
     */
    @Select("SELECT * FROM job;")
    @Results(id = "jobMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "jname", column = "jname"),
            @Result(property = "description", column = "description"),
            @Result(property = "empyees", column = "id", many = @Many(
                    select = "com.mybatisannotation.dao.EmpyeeDao.findByJobId",
                    fetchType = FetchType.EAGER
            )),
    })
    public List<Job> findAll();

    /**
     * 根据ID查询工种
     */
    @Select("SELECT * FROM job WHERE id=#{id}")
    @ResultMap("jobMap")
    public Job findById(Integer id);
}
