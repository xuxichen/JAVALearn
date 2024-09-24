package com.mybatisannotation;

import com.mybatisannotation.dao.EmpyeeDao;
import com.mybatisannotation.dao.JobDao;
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

public class SecondLevelCacheTest {
    // 1、读取配置文件
    private InputStream in;
    SqlSession sqlSession;
    SqlSessionFactory sqlSessionFactory;
    EmpyeeDao empyeeDao;
    JobDao jobDao;

    @Before
    public void init() {
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 2、创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(in);
        // 3、使用工厂生产SqlSession对象
        sqlSession = sqlSessionFactory.openSession(true);
        // 4、使用SqlSession创建Dao接口的代理对象
        jobDao = sqlSession.getMapper(JobDao.class);
    }

    @After
    public void destory() {
//        sqlSession.commit();
        // 6、释放资源
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test() {
        System.out.println("=========");
        Job job = jobDao.findById(3);
        System.out.println(job);
        sqlSession.close();


        sqlSession = sqlSessionFactory.openSession(true);
        jobDao = sqlSession.getMapper(JobDao.class);
        Job job2 = jobDao.findById(3);
        System.out.println(job2);
        sqlSession.close();
    }


}
