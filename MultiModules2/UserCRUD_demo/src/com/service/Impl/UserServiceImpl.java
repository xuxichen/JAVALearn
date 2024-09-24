package com.service.Impl;

import com.dao.Impl.UserDaoImpl;
import com.dao.UserDao;
import com.domain.User;
import com.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public int getAllUerNumber(String name, String address, String email) {
        // 调用dao
        return userDao.getAllUerNumber(name, address, email);
    }

    @Override
    public List<User> getUers(int page, int pageSize, String name, String addres, String email) {
        return userDao.getUers(page,pageSize,name,addres,email);
    }

    @Override
    public Boolean addUer(User user) {
        return userDao.addUer(user);
    }

    @Override
    public Boolean deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public Boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public User findUser(int id) {
        return userDao.findUser(id);
    }

    @Override
    public String delSelectUser(String[] ids) {
        if (ids == null || ids.length<=0 ) return "";
        String deletefailId = "";
        for (String id : ids) {
            Boolean isdeleted = userDao.deleteUser(Integer.parseInt(id));
            if (!isdeleted) {
                deletefailId +=id+'&';
            }
        }
        return deletefailId;
    }
}
