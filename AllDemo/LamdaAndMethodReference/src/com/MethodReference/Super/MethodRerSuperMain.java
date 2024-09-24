package com.MethodReference.Super;

public class MethodRerSuperMain {
    public static void method(Greetable greetable) {
        greetable.greet();
    }
    public static void main(String[] args) {
        method(()->{
            new Student().study();
        });
        Student student = new Student();
        method(student::sayHello);

        method(student::superSayHello);
    }
}
