package com.IO.FileInputStreamDemo;

import java.io.*;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("./src/com/IO/FileOutputStreamDemo/c.txt");
            fileOutputStream = new FileOutputStream(new File("./src/com/IO/FileInputStreamDemo/w.txt"));
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
//                fileOutputStream.write(len);
//                System.out.println((char)len);
                System.out.println(new String(bytes));
                fileOutputStream.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
