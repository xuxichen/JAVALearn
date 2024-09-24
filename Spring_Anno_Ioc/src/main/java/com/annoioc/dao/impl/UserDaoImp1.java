package com.annoioc.dao.impl;
import com.annoioc.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao1")
public class UserDaoImp1 implements UserDao {

    public UserDaoImp1() {
        System.out.println("UserDaoImp1对象创建了");
    }
    public void saveAccount() {
        System.out.println("保存了账户111");
    }

    public void init(){
        System.out.println("UserDaoImp1对象初始化了");
    }

    public void destory() {
        System.out.println("UserDaoImp1对象销毁了");
    }
}
