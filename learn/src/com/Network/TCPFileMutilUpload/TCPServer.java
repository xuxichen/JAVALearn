package com.Network.TCPFileMutilUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer {

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(8888);
            File file = new File("./src/com/Network/TCPFileMutilUpload/upload");
            if (!file.exists()) {
                file.mkdir();
            }

            while (true) {
                Socket socket = ss.accept();
                new Thread(new PicThread(socket, file)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
