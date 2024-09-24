package com.factory.ui;

import com.factory.factory.BeanFactory;
import com.factory.service.UserService;
import com.factory.service.impl.UserServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
//        UserServiceImpl userServiceDao = new UserServiceImpl();
//        userServiceDao.saveAccount();

        for(int i=0;i<5;i++) {
            UserService us = (UserService) BeanFactory.getBean("userService");
            System.out.println(us);
            if (us!=null) {
                us.saveAccount();
            }
        }
    }
}
