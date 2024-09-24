package com.mybatisannotation;


import com.mybatisannotation.dao.DeptDao;
import com.mybatisannotation.dao.EmpyeeDao;
import com.mybatisannotation.domain.Dept;
import com.mybatisannotation.domain.Empyee;
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

public class DeptTest {
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
        deptDao = sqlSession.getMapper(DeptDao.class);
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
    @Test
    public void test() {
        List<Dept> depts = deptDao.findAll();
        for (Dept dept : depts) {
            System.out.println("================");
            System.out.println(dept);
            List<Empyee> empyees = dept.getEmpyees();
            if (empyees != null && empyees.size()>0) {
                for (Empyee empyee : empyees) {
                    System.out.println(empyee);
                }
            }
        }
    }


    @Test
    public void testfindById() {
        System.out.println("=========");
        Dept dept = deptDao.findById(10);
        System.out.println(dept);
        List<Empyee> empyees = dept.getEmpyees();
        for (Empyee empyee : empyees) {
            System.out.println(empyee);
        }
    }

}
