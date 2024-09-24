package com.utils;

import java.io.*;

import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        try {
            Properties properties = new Properties();
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            InputStream resourceAsStream = classLoader.getResourceAsStream("com/jdbc.properties");
            properties.load(resourceAsStream);

            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");

//            Class.forName(driver);
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取链接
     * @return 链接对象
     */
    public static Connection getConnect() {

        //1、加载配置文件
        //1、1创建Properties对象

        //1、2 加载配置文件
//        try {
//            properties.load(new FileReader("Reflect/src/pro.properties"));
//            Set<String> strings = properties.stringPropertyNames();
//            for (String string : strings) {
//                System.out.println(string + "======" + properties.getProperty(string));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        }  catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void close(Statement statement, Connection connection) {
        if (statement !=null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection !=null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet !=null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement !=null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection !=null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
