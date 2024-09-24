package com.mybatisannotation;


import com.mybatisannotation.dao.DeptDao;
import com.mybatisannotation.dao.EmpyeeDao;
import com.mybatisannotation.domain.Dept;
import com.mybatisannotation.domain.Empyee;
import com.mybatisannotation.domain.Job;
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
