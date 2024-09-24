package DataSource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0 演示
 */
public class C3P0Main2 {
    public static void main(String[] args) {
        ComboPooledDataSourceDefaul();

        ComboPooledDataSourceParam("otherc3p0");

    }
    public static void ComboPooledDataSourceDefaul() {
        // 1、创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        // 2、获取连接对象

        try {
            for (int i = 1; i < 12 ; i++) {
                Connection connection = ds.getConnection();
                System.out.println( i+"default:"+connection);
                if (i==9) {
                    connection.close();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void ComboPooledDataSourceParam(String s) {
        // 1、创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource(s);
        // 2、获取连接对象

        try {
            for (int i = 1; i < 12 ; i++) {
                Connection connection = ds.getConnection();
                System.out.println( i+"param===:"+connection);
                if (i==9) {
                    connection.close();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
