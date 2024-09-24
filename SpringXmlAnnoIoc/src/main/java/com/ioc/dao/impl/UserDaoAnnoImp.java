package com.ioc.dao.impl;

import com.ioc.dao.UserDao;
import com.ioc.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("userDaoAnno")
public class UserDaoAnnoImp implements UserDao {

    @Autowired
    private QueryRunner runner;

    public UserDaoAnnoImp() {
        System.out.println("UserDaoAnnoImp对象创建了");
    }
    public void init(){
        System.out.println("UserDaoAnnoImp对象初始化了");
    }
    public void destory() {
        System.out.println("UserDaoAnnoImp对象销毁了");
    }

    public List<User> findAll() {
        try {
            return runner.query("SELECT * FROM user_demo", new BeanListHandler<User>(User.class));
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public User findById(Integer id) {
        try {
            return runner.query("SELECT * FROM user_demo WHERE id = ?", new BeanHandler<User>(User.class), id);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }


    public void saveUser(User user) {
        try {
            runner.update("INSERT INTO user_demo (name, gender, age, address, qq, email) VALUES (?, ?, ?, ?, ?, ?);",
                    user.getName(),user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public void updateUser(User user) {
        try {
            runner.update("UPDATE user_demo set qq=? WHERE id=?",user.getQq(),user.getId());
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public void deleteUser(User user) {
        try {
            runner.update("DELETE FROM user_demo WHERE id=?", user.getId());
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
