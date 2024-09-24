package com.innerClass;

public class Body {
    public class heart {
        public void beat() {
            System.out.println("我叫"+name);
            System.out.println("心脏跳动");
        }
    }

    private String name;
    public void methodBody() {
        System.out.println("外部类的方法");
        new heart().beat();
    }
}
