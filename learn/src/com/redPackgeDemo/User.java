package com.redPackgeDemo;

public class User {

    private String name;        // 姓名
    private Double money;          // 余额

    public User() {
    }

    public User(String name, Double money) {
        this.name = name;
        this.money = money;
    }

    public void show() {
        System.out.println("我叫： " + name + ", 我有" + money + "元的钱");
    }

    public String getName() {
        return name;
    }

    public Double getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
