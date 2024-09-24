package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {

        // 1、创建真实对象
        Lenovo lenovo = new Lenovo();

        // 2、动态代理对象增强lenovo对象

        SaleComputer proxyInstance = (SaleComputer)Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {


            /**
             * 代理逻辑编写的方法：代理对象调用所有方法都会触发改方法执行
             * @param proxy 代理对象
             * @param method  代理对象的方法被封装成对象
             * @param args  代理对象调用的方法时，传递的实际参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("该方法被执行了");

                // 判断是否是set方法
                if (method.getName().equals("sale")) {
                    // 1、增强参数
                    double money = (double)args[0];
                    money = money*0.85;

                    //使用真实对象调用该方法
                    String invoke = (String) method.invoke(lenovo, money);

                    // 2、增强返回值
                    invoke = invoke + "键盘，鼠标";
                    return invoke;
                } else {
                    //使用真实对象调用该方法
                    Object invoke = method.invoke(lenovo, args);
                    return invoke;
                }
            }
        });
        // 3、调用方法
        String sale = proxyInstance.sale(8000);
        System.out.println(sale);
    }
}
