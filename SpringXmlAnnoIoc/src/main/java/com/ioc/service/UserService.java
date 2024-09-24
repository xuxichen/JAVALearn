package com.ioc.service;

import com.ioc.domain.User;
import java.util.List;

public interface UserService {

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll();

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    public User findById(Integer id);

    /**
     * 添加用户
     * @param user
     */
    public void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    public void updateUser(User user);

    /**
     * 删除用户
     * @param user
     */
    public void deleteUser(User user);
}
