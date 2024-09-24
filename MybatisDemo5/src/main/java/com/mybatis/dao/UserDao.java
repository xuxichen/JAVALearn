package com.mybatis.dao;

import com.mybatis.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll();

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    public User findById(Integer userId);

    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return
     */
    public List<User> findByName(String username);

}
