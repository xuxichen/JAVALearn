package com.Network.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            OutputStream os = socket.getOutputStream();
            os.write("你好啊".getBytes());

            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
