package com.springboot.config;

import ch.qos.logback.core.db.DBHelper;
import com.springboot.bean.Car;
import com.springboot.bean.Pet;
import com.springboot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认是单实例
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods 代理bean方法
 *      Full(proxyBeanMethods = true) 保证每个@Bean方法被调用多次返回的组件都是单例
 *      Lite(proxyBeanMethods = true) 每个@Bean方法被调用多次返回的组件都是新创建的对象
 * 4、@Import({User.class, DBHelper.class})
 *      给容器中自动创建出这两个类的组件
 */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true) // 告诉springBoot这是一个配置类，等同与一个xml配置文件
//@ConditionalOnBean(name = "pet")
@ConditionalOnMissingBean(name = "pet")
@ImportResource("classpath:bean.xml")
@EnableConfigurationProperties(Car.class)
// EnableConfigurationProperties ：
//  1、开启Car配置绑定功能
//  2、把Car自动注册到容器中
public class MyConfig {

    /**
     * 外部无论对配置类中的这个组件注册方法调用了多少次获取的都是之前的注册容器中的单实例
     * @return
     */
//    @ConditionalOnBean(name = "pet")
    @Bean // 给容器添加组件，以方法名作为组件的id 返回值为组件类型
    public User inituser() {
        return new User("张三", 22);
    }

    @Bean("pet22") // 给容器添加组件，自定义组件的id 返回值为组件类型
    public Pet initPet() {
        return new Pet("Tom");
    }
}
