package com.Annotation;

import java.lang.annotation.*;

/**
 *          *@Target: 描述注解能攻作用到的位置
 *          *@Retention: 描述注解被保留的阶段
 *          *Documented: 描述注解是否被抽取到api文档中
 *          *@Inherited: 描述注解是否被子类继承
 */

@Target({ElementType.TYPE})// 表示该注解只能作用与类上
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnnota3 {
}
