package DataSource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidMain {
    public static void main(String[] args) {
        // 1、导入架包

        // 2、定义配置文件

        // 3、加载配置文件
        Properties properties = new Properties();
        ClassLoader classLoader = DruidMain.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("druid.properties");
        try {
            properties.load(resourceAsStream);
            // 4、获取连接池对象
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            for (int i = 1; i <= 12 ; i++) {
                Connection connection = dataSource.getConnection();
                System.out.println( i+"param===:"+connection);
                if (i==9) {
                    connection.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 4、
    }
}
