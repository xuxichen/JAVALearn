package com.mybatis.sqlsession.proxy;

import com.mybatis.cfg.Mapper;
import com.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 *
 */
public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection connection;

    public MapperProxy(Map<String, Mapper> mappers, Connection connection) {
        this.mappers = mappers;
        this.connection = connection;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 获取方法名
        String methodName = method.getName();
        // 获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        // 组合key
        String key = className + "." + methodName;
        // 获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        // 判断是否有mapper
        if (mapper == null) {
            throw new IllegalArgumentException();
        }

        // 调用工具类Executor执行查询所有

        return new Executor().selectList(mapper, connection);
    }
}
