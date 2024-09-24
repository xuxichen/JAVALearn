package com.Annotation;

@MyAnnota(age = 16, name = "韩东君")
@MyAnnota3
public class Worker {

//    @MyAnnota3 /* '@MyAnnota3' not applicable to field*/
    public String name;

//    @MyAnnota3 /*@MyAnnota3' not applicable to method*/
    public void Method(){

    }
}
