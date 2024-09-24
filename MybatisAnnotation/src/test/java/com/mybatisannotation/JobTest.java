package com.mybatisannotation;

import com.mybatisannotation.dao.EmpyeeDao;
import com.mybatisannotation.dao.JobDao;
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

public class JobTest {
    // 1、读取配置文件
    private InputStream in;
    SqlSession sqlSession;
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
        SqlSessionFactory sqlSessionFactory = builder.build(in);
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
            sqlSession.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test() {
        List<Job> jobs = jobDao.findAll();
        for (Job job : jobs) {
            System.out.println("=========");
            System.out.println(job);
            List<Empyee> empyees = job.getEmpyees();
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
        Job job = jobDao.findById(3);
        System.out.println(job);

        List<Empyee> empyees = job.getEmpyees();
        for (Empyee empyee : empyees) {
            System.out.println(empyee);
        }
        Job job2 = jobDao.findById(3);
        System.out.println(job2);
    }


}
