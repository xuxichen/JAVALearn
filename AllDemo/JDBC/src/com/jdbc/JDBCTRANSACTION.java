package com.jdbc;

import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTRANSACTION {
    public static void main(String[] args) {


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement2 = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;

        try {
            connection = JDBCUtils.getConnect();
            // 4、定义sql语句
            String sql="UPDATE account SET balance=balance-? where name=?;";
            String sql2="UPDATE account SET balance='balance+'? where name=?;";


            // 5、开启事务
            connection.setAutoCommit(false);

            // 6、获取执行sql对象 preparedStatement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 500);
            preparedStatement.setNString(2, "zhangsan");

            preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setInt(1, 500);
            preparedStatement2.setNString(2, "lisi");

            // 7、执行sql
            int l = preparedStatement.executeUpdate();
            int l2 = preparedStatement2.executeUpdate();

            connection.commit();
            System.out.println(l);
            System.out.println(l2);
        } catch (Exception throwables) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            // 8、释放资源
            JDBCUtils.close(preparedStatement, connection);
            JDBCUtils.close(preparedStatement2, null);
        }
    }
}
