package com.MethodReference.Constructor;

public class ConstructorMain {
    public static Person method(String name, PersonBuilder personBuilder) {
        return personBuilder.builder(name);
    }
    public static void main(String[] args) {

        Person person = method("李白", (name)->new Person(name));
        System.out.println(person);

        Person person2 = method("杜甫", Person::new);
        System.out.println(person2);
    }
}
