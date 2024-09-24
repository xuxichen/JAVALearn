package com.mybatis;

import com.mybatis.dao.UserDao;
import com.mybatis.domain.QueryVo;
import com.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {
    // 1、读取配置文件
    private InputStream in;
    SqlSession sqlSession;
    UserDao userDao;


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
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @Test
    public void test() {
        // 5、使用代理对象执行方法
        List<User> users = userDao.findAll();
        System.out.println(users);

    }

    @Test
    public void test1() {
        //使用代理对象执行方法
        User user = userDao.findById(7);
        System.out.println(user);
    }

    @Test
    public void test2() {
        //使用代理对象执行方法
        List<User> users = userDao.findByName("%张%");
        System.out.println(users);
    }

    @Test
    public void test3() {
        //使用代理对象执行方法
        List<User> users = userDao.findByName("%张%");
        System.out.println(users);
    }

    @Test
    public void test4() {
        User user = new User();
        user.setUserName("%李%");
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user);
        //使用代理对象执行方法
        List<User> users = userDao.findByVo(queryVo);
        System.out.println(users);
    }

    @Test
    public void test5() {
        //使用代理对象执行方法
        User user = new User();
        user.setUserName("%李%");
        user.setUserGender("男");
        List<User> users = userDao.findUserByCondition(user);
        System.out.println(users);
    }

    @Test
    public void test6() {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(3);
        integers.add(5);
        integers.add(8);
        integers.add(9);
        integers.add(13);
        integers.add(23);

        System.out.println(integers);
        QueryVo queryVo = new QueryVo();
        queryVo.setIds(integers);
        //使用代理对象执行方法
        List<User> users = userDao.findUserInIds(queryVo);
        for (User user : users) {
            System.out.println(user);
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
