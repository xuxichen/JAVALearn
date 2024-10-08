package com.spring.factory;

import com.spring.dao.UserDao;
import com.spring.dao.impl.UserDaoImp;

/**
 * 模拟一个工厂类（该类可能是存在于jar包中的，我们无法通过修改源码的方式来提供默认构造函数）
 */
public class InstanceFactory {
    public static UserDao getUserDao(){
        return new UserDaoImp();
    }
}
