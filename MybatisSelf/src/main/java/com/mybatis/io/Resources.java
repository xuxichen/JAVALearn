package com.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件
 */
public class Resources {

    /**
     * 根据一个传入的参数获取一个字节输入流
     * @param congfigFileName
     * @return
     */
    public static InputStream getResourceAsStream(String congfigFileName) {
        return Resources.class.getClassLoader().getResourceAsStream(congfigFileName);
    }
}
