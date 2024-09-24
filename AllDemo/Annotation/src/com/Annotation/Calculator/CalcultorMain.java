package com.Annotation.Calculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CalcultorMain {

    public static int record(int num, BufferedWriter writer, Method method, Exception e) throws IOException {
        num++;

        writer.write(method.getName() + "方法出现异常");
        writer.newLine();
        writer.flush();
        writer.write("异常名称：" + e.getCause().getClass().getSimpleName());
        writer.newLine();
        writer.flush();
        writer.write("异常原因：" + e.getCause().getMessage());
        writer.newLine();
        writer.flush();
        return num;
    }

    public static void main(String[] args) throws IOException {
        Calcultor calcultor = new Calcultor();

        Class<? extends Calcultor> aClass = calcultor.getClass();
        Method[] methods = aClass.getMethods();

        int num = 0;
        Integer[] param = {1, 0};
        BufferedWriter writer = new BufferedWriter(new FileWriter("Annotation/src/com/Annotation/Calculator/bug.txt"));

        for (Method method : methods) {
            if (method.isAnnotationPresent(CheckAnnota.class)) {
                // 是，需要检测的方式是否异常
                try {
                    method.invoke(calcultor, param);
                } catch (IllegalAccessException e) {
                    num = record(num, writer, method, e);
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    num = record(num, writer, method, e);
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                    num = record(num, writer, method, e);
                }
            }
        }
        writer.write("本次测试一共出现" + num + "次错误");
        writer.close();
    }
}
