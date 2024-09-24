package com.spring.dao.impl;

import com.spring.dao.UserDao;

import java.util.Date;

public class UserDaoImp2 implements UserDao {

    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public UserDaoImp2() {
        System.out.println("UserDaoImp2对象创建了");
    }
    public void saveAccount() {
        System.out.println("保存了账户"+name+","+age+","+birthday);
    }

    public void init(){
        System.out.println("UserDaoImp1对象初始化了");
    }

    public void destory() {
        System.out.println("对象销毁了");
    }
}
