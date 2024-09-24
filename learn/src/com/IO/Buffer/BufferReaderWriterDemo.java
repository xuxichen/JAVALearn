package com.IO.Buffer;

import java.io.*;

public class BufferReaderWriterDemo {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            fr = new FileReader("./src/com/IO/FileInputStreamDemo/w.txt");
            fw = new FileWriter("./src/com/IO/Buffer/多希望.txt");

            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

            int len = 0;
            char[] bytes = new char[1024];
            while ((len = br.read(bytes)) != -1) {
                bw.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
