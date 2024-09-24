package com.springboot;

import ch.qos.logback.core.db.DBHelper;
import com.springboot.bean.Pet;
import com.springboot.bean.User;
import com.springboot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序类
 */
// 只能扫描当前文件所在的包下面的所有注解，
// 如果当前文件的包的目录下，则需要指定扫描的路径
@SpringBootApplication
//与下面的注解功能类似
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.springboot")
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
//        String[] names = run.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
//        User user = run.getBean("inituser", User.class);
//        System.out.println(user);


//        Pet pet = run.getBean("pet", Pet.class);
//        Pet pet1 = run.getBean("pet", Pet.class);
//        System.out.println(pet == pet1);
//
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//
//        // 如果MyConfig中的@Configuration(proxyBeanMethods = true)代理对象调用方法，
//        // SpringBoot总会检查这个组件是否在容器中存在，保持组件单实例
//
//        User user1 = bean.inituser();
//        User user2 = bean.inituser();
//        System.out.println(user1 == user2);
//
//        DBHelper dbHelper = run.getBean(DBHelper.class);
//        System.out.println(dbHelper);
        // ============================
//        boolean b = run.containsBean("pet");
//        System.out.println(b);
//        boolean b1 = run.containsBean("inituser");
//        System.out.println(b1);
//
//        boolean b2 = run.containsBean("pet22");
//        System.out.println(b2);

        boolean hhe = run.containsBean("hhe");
        System.out.println(hhe);
    }
}
