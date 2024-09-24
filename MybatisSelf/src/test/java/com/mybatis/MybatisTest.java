package com.mybatis;

import com.mybatisSelf.dao.UserDao;
import com.mybatisSelf.domain.User;

import com.mybatis.io.Resources;
import com.mybatis.sqlsession.SqlSession;
import com.mybatis.sqlsession.SqlSessionFactory;
import com.mybatis.sqlsession.SqlSessionFactoryBuilder;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void test() {
        // 1、读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2、创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(in);
        // 3、使用工厂生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4、使用SqlSession创建Dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        // 5、使用代理对象执行方法
        List<User> users = userDao.findAll();
        System.out.println(users);
        // 6、释放资源
        try {
            sqlSession.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
