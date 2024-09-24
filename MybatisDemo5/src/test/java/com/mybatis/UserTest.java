package com.mybatis;

import com.mybatis.dao.RoleDao;
import com.mybatis.dao.UserDao;
import com.mybatis.domain.Role;
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

public class UserTest {
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
        // 5、使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("======");
            System.out.println(user);
            List<Role> roles = user.getRoles();
            if (roles !=null && roles.size()>0) {
                for (Role role : roles) {
                    System.out.println(role);
                }
            }
        }
        }


}
