package com.mybatis.dao;

import com.mybatis.domain.Role;
import java.util.List;

/**
 *  角色持久层接口
 */
public interface RoleDao {

    /**
     * 查询所有角色
     * @return
     */
    public List<Role> findAll();


}
