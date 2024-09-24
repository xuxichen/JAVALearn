package com.IO.Buffer;

import java.io.*;

public class BufferStreamDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        BufferedInputStream bufferedInputStream = null;

        FileOutputStream fos = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fis = new FileInputStream("./src/com/IO/FileInputStreamDemo/抖音.mp4");
            bufferedInputStream = new BufferedInputStream(fis);

            fos = new FileOutputStream("./src/com/IO/Buffer/很思念你啊.mp4");
            bufferedOutputStream = new BufferedOutputStream(fos);

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedInputStream.close();
                fis.close();

                bufferedOutputStream.close();
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
