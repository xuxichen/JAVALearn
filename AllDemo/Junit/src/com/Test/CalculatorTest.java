package com.Test;

import com.Junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    /**
     * 初始化方法
     * 用于资源申请，所有的测试方法在执行之前都会先执行该方法
     */
    @Before
    public void init() {
        System.out.println("init");
    }

    /**
     * 释放资源法方
     * 用于测试完成之后释放资源与
     */
    @After
    public void close() {
        System.out.println("close....");
    }
    /**
     * 测试add方法
     */
    @Test
    public void testAdd() {
        System.out.println("我被执行了");
        Calculator calculator = new Calculator();

        int sum = calculator.add(1,2);

        // 断言， 断言结果
        Assert.assertEquals(3,sum);

    }
}
