package com.dao;

import com.domain.User;
import com.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * 操作数据库User表的类
 */
public class UserDao {
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登陆方法
     * @param login 只有用户名和密码
     * @return user包含user所有数据
     */
    public User login(User login) {
        try {
            String sql="SELECT * FROM user WHERE username=? AND password=?;";
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), login.getUsername(), login.getPassword());
            return user;
        } catch (DataAccessException e) {
//            e.printStackTrace();
            return null;
        }
    }


}
