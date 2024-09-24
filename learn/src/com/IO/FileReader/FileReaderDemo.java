package com.IO.FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("./src/com/IO/FileInputStreamDemo/w.txt");
            fileWriter = new FileWriter("./src/com/IO/FileReader/美好.txt");
            int len = 0;
            char[] chars = new char[1024];
            while ((len = fileReader.read(chars)) != -1) {
                fileWriter.write(chars);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
