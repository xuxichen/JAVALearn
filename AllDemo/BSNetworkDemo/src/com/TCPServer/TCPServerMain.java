package com.TCPServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPServerMain {
    public static void main(String[] args) {

        try {

            // 创建一个端口号为8080的服务器ServerSocket
            ServerSocket server = new ServerSocket(8080);
            // 使用accept 的方法获取到请求的客户端对象
            Socket socket = server.accept();

            // 使用socket获取网路字节流
            InputStream is = socket.getInputStream();

            // 把inputStream网络字节流转成字符输入缓冲流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            // 把客户端请求信息第一行读取出来 GET XX
            String line = br.readLine();
            // 把读取的信息进行切割，重要中间部分得到访问的路径
            String[] al = line.split(" ");
            // 把截取到路径第一个斜杠去掉就是文件所在的路径
            String htmlPath = al[1].substring(1);

            // 创建一个本地字节流输入流。构造方法中绑定要读取的html路径
            FileInputStream fis = new FileInputStream(htmlPath);
            // 使用socket中的方法getOutputStream获取网络字节输出流OutputStream对象
            OutputStream os = socket.getOutputStream();
            /**
             * 下面三行固定写法
             */
            // 写入HTTP协议响应头，固定写法
            os.write("HTTP/1.1 200 OK \r\n".getBytes());
            os.write("Content-Type:text/html\r\n".getBytes());
            //必须写入空行。否则浏览器不解析
            os.write("\r\n".getBytes());

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                os.write(bytes, 0, bytes.length);
            }
            is.close();
            fis.close();
            os.close();
            socket.close();
            server.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
