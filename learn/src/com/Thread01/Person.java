package com.Thread01;

public class Person extends Thread{

    private String pname;
    private Integer age;

    public Person(String pname, Integer age) {
        this.pname = pname;
        this.age = age;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(pname + "---->" + i);
        }
    }
}
