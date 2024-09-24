package com.mybatis.sqlsession;

public interface SqlSessionFactory {

    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    public SqlSession openSession();
}
