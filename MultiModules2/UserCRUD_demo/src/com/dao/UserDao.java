package com.dao;

import com.domain.User;

import java.util.List;

public interface UserDao {

    abstract public int getAllUerNumber(String name, String address, String email);

    abstract public List<User> getUers(int page, int pageSize, String name, String addres, String email);

    abstract public Boolean addUer(User user);

    abstract public Boolean deleteUser(int id);

    abstract public Boolean updateUser(User user);

    abstract public User login(User user);

    abstract public User findUser(int id);
}
