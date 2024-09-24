package com.aanoioc;

import com.annoioc.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class AnnoIoc {

    // 1、读取配置文件
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

    @Before
    public void init() {

    }

    @After
    public void destory() {
        context.close();
    }

    @Test
    public void test() {
        UserService userService = (UserService)context.getBean("userServiceImpl");
        userService.saveAccount();

    }



}
