package com.mybatis.dao;

import com.mybatis.domain.User;
import org.apache.ibatis.annotations.Insert;

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
     * 保存用户
     * @param user
     */
    public void SaveUser(User user);


    /**
     * 更新用户数据
     * @param user
     */
    public void updateUser(User user);

    /**
     * 删除用户
     * @param user
     */
    public void deletedUser(User user);
}
