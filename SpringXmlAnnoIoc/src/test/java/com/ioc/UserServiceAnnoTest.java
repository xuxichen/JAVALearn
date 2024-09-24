package com.ioc;

import com.ioc.domain.User;
import com.ioc.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserServiceAnnoTest {

    // 1、读取配置文件
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beananno.xml");
    UserService userService;
    @Before
    public void init() {
        userService = (UserService)context.getBean("userServiceAnno");
    }

    @After
    public void destory() {

    }
    /**
     * 查询所有用户
     * @return
     */
    @Test
    public void findAll() {
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @Test
    public void findById() {
        User user = userService.findById(6);
        System.out.println(user);
    }

    /**
     * 添加用户
     * @param user
     */
    @Test
    public void saveUser() {
        User user = new User();
        user.setName("李去浊");
        user.setGender("男");
        user.setAge(29);
        user.setAddress("四川");
        user.setQq("20398324");
        user.setEmail("liquzhuo@qq.com");
        userService.saveUser(user);
    }

    /**
     * 更新用户
     * @param user
     */
    @Test
    public void updateUser() {
        User user = new User();
        user.setId(32);
        user.setQq("869655755");
        userService.updateUser(user);
    }

    /**
     * 删除用户
     * @param user
     */
    @Test
    public void deleteUser() {
        User user = new User();
        user.setId(32);
        userService.deleteUser(user);
    }
}
