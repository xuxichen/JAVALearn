package com.IO.ObjectStream;

import java.io.*;
import java.util.ArrayList;

public class ObjectStreamDemo1 {
    public static void main(String[] args) {
        Person teacher = new Person("夫子",69);
        Person student1 = new Person("李慢慢", 30);
        Person student2 = new Person("余莲",35);
        Person student3 = new Person("陈皮皮", 15);

        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(teacher);
        arrayList.add(student1);
        arrayList.add(student2);
        arrayList.add(student3);


        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {

            fos = new FileOutputStream("./src/com/IO/ObjectStream/arrayList.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(arrayList);
            oos.writeObject(null);

            oos.flush();
            fos.flush();

            fis =  new FileInputStream("./src/com/IO/ObjectStream/arrayList.txt");
            ois = new ObjectInputStream(fis);
            ArrayList<Person> personList = null;
            while ((personList = (ArrayList<Person>) ois.readObject()) != null){
                for (Person p: personList) {
                    System.out.println(p);
                }
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
