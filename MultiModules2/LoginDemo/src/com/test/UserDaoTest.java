package com.test;

import com.dao.UserDao;
import com.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void TestLogin() {
        User user = new User();
        user.setUsername("lisi");
        user.setPassword("user123");

        User login = new UserDao().login(user);
        System.out.println(login);
    }
}
