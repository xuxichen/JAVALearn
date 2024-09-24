package com.IO.Stream;

import java.io.*;

public class StreamReaderWriterDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            fis =  new FileInputStream("./src/com/IO/Stream/新建文本文档_GBK.txt");
            isr = new InputStreamReader(fis, "GBK");

            fos = new FileOutputStream("./src/com/IO/Stream/新建文本文档_UTF.txt");
            osw = new OutputStreamWriter(fos, "UTF-8");
            int len = 0;
//            while ((len = isr.read()) != -1) {
//                System.out.print((char)len);
//            }

            char[] chars = new char[1024];
            while ((len = isr.read(chars)) != -1) {
                osw.write(chars);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                isr.close();
                osw.close();

                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
