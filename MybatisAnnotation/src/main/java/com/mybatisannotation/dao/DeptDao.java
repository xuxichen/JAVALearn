package com.mybatisannotation.dao;

import com.mybatisannotation.domain.Dept;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface DeptDao {
    /**
     * 查询所有部门,同时获取各个部门的人员信息
     * @return
     */
    @Select("SELECT * FROM dept;")
    @Results(id = "deptMap", value = {
            @Result(id = true, property = "did", column = "id"),
            @Result(property = "dloc", column = "loc"),
            @Result(property = "empyees", column = "id", many = @Many(
                    select = "com.mybatisannotation.dao.EmpyeeDao.findByDeptId",
                    fetchType = FetchType.EAGER
            ))
    })
    public List<Dept> findAll();

    /**
     * 根据ID查询部门
     */
    @Select("SELECT * FROM dept WHERE id=#{id}")
//    @ResultMap(value = {"deptMap"})
    @ResultMap("deptMap")
    public Dept findById(Integer id);
}
