package com.IO.ObjectStream;

import java.io.*;

public class ObjectStreamDemo {
    public static void main(String[] args) {
        Person teacher = new Person("夫子",69);
        Person student = new Person("李慢慢", 30);

        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {

            fos = new FileOutputStream("./src/com/IO/ObjectStream/Person.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(teacher);
            oos.writeObject(student);
            oos.writeObject(null);

            oos.flush();
            fos.flush();

            fis =  new FileInputStream("./src/com/IO/ObjectStream/Person.txt");
            ois = new ObjectInputStream(fis);
            Person person = null;
            while ((person = (Person) ois.readObject()) != null){
                System.out.println(person);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                oos.close();

                ois.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
