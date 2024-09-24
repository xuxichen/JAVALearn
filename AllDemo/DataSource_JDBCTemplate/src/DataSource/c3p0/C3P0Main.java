package DataSource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0 演示
 */
public class C3P0Main {
    public static void main(String[] args) {

        // 1、创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        // 2、获取连接对象
        Connection connection = null;
        try {
            connection = ds.getConnection();

            System.out.println(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
