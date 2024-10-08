package com.spring.ui;


import com.spring.dao.UserDao;
import com.spring.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     *
     * ApplicationContext的三个常用实现类：
     *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。(更常用)
     *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须有访问权限）
     *
     *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的，是明天的内容。
     *
     * 核心容器的两个接口引发出的问题：
     *  ApplicationContext:     单例对象适用              采用此接口
     *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。
     *
     *  BeanFactory:            多例对象使用
     *      它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。
     *
     */
    public static void main(String[] args) {
//        // 1、获取核心容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        // 2、根据id获取Bean对象
//        UserService us = (UserService)context.getBean("userService");
//        UserDao userDao = context.getBean("userDao", UserDao.class);
//
//        System.out.println(us);
//        System.out.println(userDao);
//        userDao.saveAccount();
//        context.close();
//        us.saveAccount();

////        BeanFactory
//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        UserService userService = (UserService)factory.getBean("userService");
//        System.out.println(userService);

//        // 根据id获取Bean对象
        UserDao userDao1 = (UserDao)context.getBean("userDao1");
        userDao1.saveAccount();

        System.out.println("============");
        UserDao userDao2 = (UserDao)context.getBean("userDao2");
        userDao2.saveAccount();

        System.out.println("============");
        UserDao userDao3 = (UserDao)context.getBean("userDao3");
        userDao3.saveAccount();
    }
}
