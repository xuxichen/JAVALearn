package com.ioc.service.impl;

import com.ioc.dao.UserDao;
import com.ioc.domain.User;
import com.ioc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userServiceAnno")
public class UserServiceAnnoImpl implements UserService {

    @Resource(name = "userDaoAnno")
    private UserDao userDao;

    public UserServiceAnnoImpl() {
        System.out.println("UserServiceAnnoImpl创建了");
    }
    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(Integer id) {
        return userDao.findById(id);
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
}
