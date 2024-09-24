package com.mybatis;

import com.mybatis.dao.UserDao;
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
        sqlSession = sqlSessionFactory.openSession();
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
    public void test2() {
        User user = new User();
        user.setName("王也");
        user.setGender("男");
        user.setAge(17);
        user.setAddress("北京");
        user.setQq("9887677");
        user.setEmail("wangye@qq.com");

        userDao.SaveUser(user);

        sqlSession.commit();
    }

    @Test
    public void test3() {
        User user = new User();
        user.setId(26);
        user.setQq("9527");
        userDao.updateUser(user);

        sqlSession.commit();
    }

    @Test
    public void test4() {
        User user = new User();
        user.setId(27);
        userDao.deletedUser(user);


    }

    @After
    public void destory() {
        sqlSession.commit();
        // 6、释放资源
        try {
            sqlSession.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
