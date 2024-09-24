package com.transfer.utils;

import javax.sql.DataSource;
import java.sql.Connection;

public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection() {
        try {
            // 1、从线程ThreadLocal上获取连接
            Connection connection = tl.get();
            //2.判断当前线程上是否有连接
            if (connection == null) {
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                 connection = dataSource.getConnection();
                 tl.set(connection);
            }
            //4.返回当前线程上的连接
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection() {
        tl.remove();;
    }
}
