package com.mybatis.dao;

import com.mybatis.domain.QueryVo;
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

    /**
     * 根据queryvo中的条件查询用户
     * @param vo
     * @return
     */
    public List<User> findByVo(QueryVo vo);

    /**
     * 根据传入的参数条件查询
     * @param user 查询条件：有可能有用户名，有可能有性别，也有可能有地址，还有可能都有
     * @return
     */
    public List<User> findUserByCondition(User user);


    /**
     * 根据queryvo中提供的id集合，查询用户信息
     * @param vo
     * @return
     */
    public List<User> findUserInIds(QueryVo vo);
}
