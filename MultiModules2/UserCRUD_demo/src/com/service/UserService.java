package com.service;

import com.domain.User;
import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 获取用户总数
     * @return
     */
    abstract public int getAllUerNumber(String name, String address, String email);

    /**
     * 获取用户列表数
     * @param page 页码
     * @param pageSize 每页大小
     * @param name 过滤条件用户名 （模糊查询）
     * @param addres 过滤条件 地址  （模糊查询）
     * @param email 过滤条件 邮箱 （模糊查询）
     * @return 用户列表
     */
    abstract public List<User> getUers(int page, int pageSize, String name, String addres, String email);

    /**
     * 添加用户
     * @param user
     * @return
     */
    abstract public Boolean addUer(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    abstract public Boolean deleteUser(int id);


    /**
     * 修改用户数据
     * @param user
     * @return
     */
    abstract public Boolean updateUser(User user);


    /**
     * 登陆
     * @param user
     * @return
     */
    abstract public User login(User user);

    /**
     * 以id查询用户
     * @param id
     * @return
     */
    abstract public User findUser(int id);

    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    abstract public String delSelectUser(String[] ids);

}
