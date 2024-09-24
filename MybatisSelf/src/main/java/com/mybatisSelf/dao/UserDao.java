package com.mybatisSelf.dao;

import com.mybatis.annotation.Select;
import com.mybatisSelf.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
//    @Select("SELECT * FROM user_demo")
    public List<User> findAll();
}
