package com.mybatisannotation.dao;

import com.mybatisannotation.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("SELECT * FROM user_demo;")
    public List<User> findAll();

    /**
     * 根据ID查询
     * @return
     */
    @Select("SELECT * FROM user_demo WHERE id=#{id};")
    public User findByID(Integer id);

    /**
     * 根据名称模糊查询
     * @param name SQL语句中如果是用 '%${}%'花括号中固定是value
     * @return
     */
//    @Select("SELECT * FROM user_demo WHERE name LIKE #{name};")
    @Select("SELECT * FROM user_demo WHERE name LIKE '%${name}%';")
    public List<User> findByUsername(String name);

    /**
     * 保存用户
     * @param user
     */
    @Insert(value = "INSERT INTO user_demo (name, gender, age, address, qq, email) VALUES " +
            "(#{name}, #{gender}, #{age}, #{address},#{qq}, #{email});")
    public void SaveUser(User user);


    /**
     * 更新用户数据
     * @param user
     */
    @Update("UPDATE user_demo set name=#{name, jdbcType=VARCHAR}, gender=#{gender}, age=#{age}, address=#{address}, qq=#{qq}, email=#{email} WHERE id=#{id};")
    public void updateUser(User user);

    /**
     * 删除用户
     * @param user
     */
    @Delete("DELETE FROM user_demo WHERE id=#{id}")
    public void deletedUser(User user);
}
