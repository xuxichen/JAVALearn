package com.jdbc;

import java.sql.*;

public class JDBCDemo5 {
    public static void main(String[] args) {
        // 1、导入jar包。
            // 1、复制jar文件进libs文件夹
            // 2、右键libs文件加Add as Library
        // 2、注册驱动自动注册驱动
//        Class.forName("com.mysql.jdbc.Driver");

        // 3、获取数据库的链接对象
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin123");
            // 4、定义一个sql语句
            String sql="SELECT * FROM account;";

            // 5、获取执行sql对象 Statement
            statement = connection.createStatement();

            // 6、执行sql
            resultSet = statement.executeQuery(sql);
            // 7、处理结果

            while (resultSet.next()) {
                int anInt = resultSet.getInt(1);
                String name = resultSet.getString("name");
                double aDouble = resultSet.getDouble(3);
                System.out.println("id == "+ anInt+ "名字是："+name+"薪水是："+aDouble+"元");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 8、释放资源
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }



    }
}
