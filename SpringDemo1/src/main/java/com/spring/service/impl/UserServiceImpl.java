package com.spring.service.impl;

import com.spring.dao.UserDao;


import com.spring.dao.impl.UserDaoImp;
import com.spring.service.UserService;
import org.springframework.beans.factory.BeanFactory;

public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        System.out.println("UserService 创建了");
    }

    private UserDao userDao = new UserDaoImp();
    private int i = 1;
    public void saveAccount() {
        userDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
