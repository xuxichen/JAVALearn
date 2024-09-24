package com.Network.TCPFileUpload;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {

        FileInputStream fis = null;
        BufferedInputStream bufferedInputStream = null;

        Socket socket = null;
        OutputStream os = null;

        try {
            fis = new FileInputStream("./src/com/IO/FileInputStreamDemo/抖音.mp4");
            bufferedInputStream = new BufferedInputStream(fis);

            socket = new Socket("127.0.0.1", 8888);
            os = socket.getOutputStream();

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                os.write(bytes);
            }
            System.out.println("上传完了");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {


            try {
                bufferedInputStream.close();
                fis.close();
                os.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
