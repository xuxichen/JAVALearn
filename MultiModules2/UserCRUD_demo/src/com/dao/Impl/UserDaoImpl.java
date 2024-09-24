package com.dao.Impl;

import com.dao.UserDao;
import com.domain.User;
import com.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int getAllUerNumber(String name, String address, String email) {
        if (name == null || name == "undefined") {
            name = "";
        }
        if (address == null || address == "undefined") {
            address = "";
        }
        if (email == null || email == "undefined") {
            email = "";
        }
        String sql = "SELECT COUNT(id) count FROM user_demo WHERE isdeleted=false " +
                "AND name like '%" + name + "%'" +
                "AND address like '%" + address + "%' " +
                "AND email like '%" + email + "%'";
        try {
            Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
            return integer;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public List<User> getUers(int page, int pageSize, String name, String address, String email) {
        if (name == null || name == "undefined") {
            name = "";
        }
        if (address == null || address == "undefined") {
            address = "";
        }
        if (email == null || email == "undefined") {
            email = "";
        }
        String sql = "SELECT * FROM user_demo " +
                "WHERE isdeleted=false " +
                "AND name like '%" + name + "%'" +
                "AND address like '%" + address + "%' " +
                "AND email like '%" + email + "%'" +
                "LIMIT ?, ?;";


        try {
            List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), page * pageSize, pageSize);
            return users;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Boolean addUer(User user) {
        String sql = "INSERT INTO user_demo (name, gender, age, address, qq, email) VALUES (?, ?, ?, ?, ?, ?);";
        int update = jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        return update > 0;
    }

    public Boolean deleteUser(int id) {
        String sql = "update user_demo set isdeleted=true where id=?;";
        try {
            int update = jdbcTemplate.update(sql, id);
            return update > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Boolean updateUser(User user) {
        String sql = "update user_demo set name=?, gender=?, age=?, address=?, qq=?, email=? where id=?;";
        try {
            int update = jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
            return update > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User login(User user) {
        String sql = "SELECT * FROM user_demo " +
                "WHERE isdeleted=false " +
                "AND rule=1 " +
                "AND username=? " +
                "AND password=?";
        try {
            User loginuser = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
            return loginuser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findUser(int id) {
        String sql = "SELECT * FROM user_demo WHERE isdeleted=false AND id=?";
        try {
            User users = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}