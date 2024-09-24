package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo2 {
    public static void main(String[] args) {
        // 1、导入jar包。
            // 1、复制jar文件进libs文件夹
            // 2、右键libs文件加Add as Library
        // 2、注册驱动自动注册驱动
//        Class.forName("com.mysql.jdbc.Driver");

        // 3、获取数据库的链接对象
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin123");
            // 4、定义一个sql语句
            String sql="INSERT INTO account (name, balance) VALUES ('wangwu', 2300), ('zhaoliu', 34000);";

            // 5、获取执行sql对象 Statement
            statement = connection.createStatement();

            // 6、执行sql
            long l = statement.executeLargeUpdate(sql);
            // 7、处理结果
            System.out.println(l);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 8、释放资源
            try {
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }



    }
}
