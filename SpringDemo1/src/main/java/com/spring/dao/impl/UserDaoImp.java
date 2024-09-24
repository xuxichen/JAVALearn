package com.spring.dao.impl;

import com.spring.dao.UserDao;

public class UserDaoImp implements UserDao {

    public UserDaoImp() {
        System.out.println("UserDaoImp对象创建了");
    }
    public void saveAccount() {
        System.out.println("保存了账户");
    }

    public void init(){
        System.out.println("对象初始化了");
    }

    public void destory() {
        System.out.println("对象销毁了");
    }
}
