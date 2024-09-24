package com.IO.FileOutputStreamDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IODemo01 {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        FileOutputStream fos = null;
        FileOutputStream fos1 = null;
        try {
            fileOutputStream = new FileOutputStream("./src/com/IO/FileOutputStreamDemo/a.txt");
            fileOutputStream.write(97);

            fos = new FileOutputStream(new File("./src/com/IO/FileOutputStreamDemo/b.txt"));
            fos.write(49);
            fos.write(48);
            fos.write(48);
            byte[] bytes = {65, 66, 67, 68, 69, 70};
            fos.write(bytes);

            fos.write(bytes, 2, 2);

            byte[] bytes1 = "我爱Java， 学习Java".getBytes();
            System.out.println(Arrays.toString(bytes1));
            fos.write(bytes1);


            fos1 = new FileOutputStream("./src/com/IO/FileOutputStreamDemo/c.txt", true);
            byte[] bytes2 = "HELLO，WORD".getBytes();
            System.out.println(Arrays.toString(bytes2));
            String line = System.getProperty("line.separator");
            for (int i = 0; i < 10; i++) {
                fos1.write(bytes2);
                fos1.write(line.getBytes());
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
