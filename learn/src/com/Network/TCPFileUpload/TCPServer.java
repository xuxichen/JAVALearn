package com.Network.TCPFileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        BufferedOutputStream bufferedOutputStream = null;

        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        try {
            File file = new File("./src/com/Network/TCPFileUpload/upload/");
            if (!file.exists()) {
                file.mkdirs();
            }

            fos = new FileOutputStream(file+"/很思念你啊.mp4");
            bufferedOutputStream = new BufferedOutputStream(fos);

            ss = new ServerSocket(8888);
            socket = ss.accept();
            is = socket.getInputStream();
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = is.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes);
            }
            System.out.println("接收完了");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedOutputStream.close();
                fos.close();
                is.close();
                socket.close();
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
