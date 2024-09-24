package com.mybatisannotation.dao;





import com.mybatisannotation.domain.Empyee;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface EmpyeeDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("SELECT\n" +
            "            id,\n" +
            "            ename,\n" +
            "            job_id,\n" +
            "            salary,\n" +
            "            bonus,\n" +
            "            (select ename from empyee t2 where empyee.mgr = t2.id) mgr_name,\n" +
            "            joindate,\n" +
            "            dept_id\n" +
            "        FROM\n" +
            "            empyee;")
    @Results(id = "empyeedeptjobMap",value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "ename", column = "ename"),
            @Result(property = "job_id", column = "job_id"),
            @Result(property = "mgr_name", column = "mgr_name"),
            @Result(property = "joindate", column = "joindate"),
            @Result(property = "salary", column = "salary"),
            @Result(property = "bonus", column = "bonus"),
            @Result(property = "dept_id", column = "dept_id"),
            @Result(property = "dept", column = "dept_id", one = @One(select = "com.mybatisannotation.dao.DeptDao.findById",fetchType = FetchType.EAGER)),
            @Result(property = "job", column = "job_id", one = @One(select = "com.mybatisannotation.dao.JobDao.findById",fetchType = FetchType.EAGER))

    })
    public List<Empyee> findAll();


    /**
     * 根据部门ID查询部门员工
     */
    @Select("SELECT\n" +
            "            id,\n" +
            "            ename,\n" +
            "            job_id,\n" +
            "            salary,\n" +
            "            bonus,\n" +
            "            (select ename from empyee t2 where empyee.mgr = t2.id) mgr_name,\n" +
            "            joindate,\n" +
            "            dept_id\n" +
            "        FROM\n" +
            "            empyee\n" +
            "        WHERE dept_id=#{deptid}")
    public List<Empyee> findByDeptId(Integer deptid);

    /**
     * 根据工作ID查询工种员工
     */
    @Select("SELECT\n" +
            "            id,\n" +
            "            ename,\n" +
            "            job_id,\n" +
            "            salary,\n" +
            "            bonus,\n" +
            "            (select ename from empyee t2 where empyee.mgr = t2.id) mgr_name,\n" +
            "            joindate,\n" +
            "            dept_id\n" +
            "        FROM\n" +
            "            empyee\n" +
            "        WHERE job_id=#{jobid}")
    public List<Empyee> findByJobId(Integer jobid);
}
