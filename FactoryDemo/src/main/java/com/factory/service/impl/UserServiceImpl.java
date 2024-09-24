package com.factory.service.impl;

import com.factory.dao.UserDao;
import com.factory.dao.impl.UserDaoImp;
import com.factory.factory.BeanFactory;
import com.factory.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = (UserDao)BeanFactory.getBean("userDao");
    private int i = 1;
    public void saveAccount() {
        userDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
