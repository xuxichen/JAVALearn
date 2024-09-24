package com.mybatis;

import com.mybatis.dao.DeptDao;
import com.mybatis.dao.EmpyeeDao;

import com.mybatis.domain.Dept;
import com.mybatis.domain.Empyee;
import com.mybatis.domain.EmpyeeDeptJob;
import com.mybatis.domain.Job;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EmpyeeTest {
    // 1、读取配置文件
    private InputStream in;
    SqlSession sqlSession;
    EmpyeeDao empyeeDao;
    DeptDao deptDao;

    @Before
    public void init() {
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 2、创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(in);
        // 3、使用工厂生产SqlSession对象
        sqlSession = sqlSessionFactory.openSession(true);
        // 4、使用SqlSession创建Dao接口的代理对象
        empyeeDao = sqlSession.getMapper(EmpyeeDao.class);
        deptDao = sqlSession.getMapper(DeptDao.class);
    }

    @Test
    public void test() {
        // 5、使用代理对象执行方法
        List<Empyee> empyees = empyeeDao.findAll();
        for (Empyee empyee : empyees) {
            System.out.println(empyee);
            Dept dept = empyee.getDept();
            System.out.println(dept);
            Job job = empyee.getJob();
            System.out.println(job);
        }

    }

    @Test
    public void test1() {
        //使用代理对象执行方法
        List<Dept> depts = deptDao.findAll();
        for (Dept dept : depts) {
            System.out.println(dept);
        }

    }

    @Test
    public void test2() {
        //使用代理对象执行方法
        List<EmpyeeDeptJob> empyeeDeptJobs = empyeeDao.findAllEmpyee();
        for (EmpyeeDeptJob e : empyeeDeptJobs) {
            System.out.println(e);
        }

    }

    @After
    public void destory() {
//        sqlSession.commit();
        // 6、释放资源
        try {
            sqlSession.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
