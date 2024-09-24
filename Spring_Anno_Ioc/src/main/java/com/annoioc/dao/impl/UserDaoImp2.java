package com.annoioc.dao.impl;
import com.annoioc.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao2")
public class UserDaoImp2 implements UserDao {

    public UserDaoImp2() {
        System.out.println("UserDaoImp2对象创建了");
    }
    public void saveAccount() {
        System.out.println("保存了账户222");
    }

    public void init(){
        System.out.println("UserDaoImp2对象初始化了");
    }

    public void destory() {
        System.out.println("UserDaoImp2对象销毁了");
    }
}
