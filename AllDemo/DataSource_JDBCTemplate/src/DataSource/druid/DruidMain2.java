package DataSource.druid;

import DataSource.utils.JDBCUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class DruidMain2 {
    public static void main(String[] args) {
        System.out.println("请输入用户名并以回车键结束:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        System.out.println("请输入密码并以回车键结束");
        String password = scanner.next();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnect();
            // 4、定义一个sql语句
//            String sql = "SELECT username,password FROM user;";
            String sql="SELECT username FROM user WHERE username=? AND password=?;";

            String[] param = {username, password};

            // 5、获取执行sql对象 Statement
//            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setNString(1, username);
            preparedStatement.setNString(2,password);
            // 6、执行sql
            resultSet = preparedStatement.executeQuery();

            // 7、处理结果
            if (resultSet.next()) {
                System.out.println("登陆成功");
            } else {
                System.out.println("用户名或密码错误");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 8、释放资源
            JDBCUtils.close(resultSet, preparedStatement, connection);

        }
    }
}
