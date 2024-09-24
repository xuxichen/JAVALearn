package com.Network.TCPFileMutilUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class PicThread implements Runnable {
    private Socket socket;

    private File file;

    public PicThread() {
    }

    public PicThread(Socket socket, File file) {
        this.socket = socket;
        this.file = file;
    }


    @Override
    public void run() {

        FileOutputStream fos = null;
        BufferedOutputStream bufferedOutputStream = null;

        InputStream is = null;


        try {
            is = socket.getInputStream();
            /**
             * 获取文件后缀
             */
            int l = 0;
            byte[] b = new byte[3];
            is.read(b, 0, b.length);
            String filelast = bytesToHexString(b);
            System.out.println("文件的后缀数字是： "+filelast);
            filelast = filelast.toUpperCase();
            String ooo = checkType(filelast);
            System.out.println("文件的后缀是： "+ooo);
            if (ooo != "0000") {
                String fileName = "/IMG_" + System.currentTimeMillis() + "_" + new Random().nextInt(9999) + "."+ ooo;

                fos = new FileOutputStream(file+fileName);

                bufferedOutputStream = new BufferedOutputStream(fos);

                // 写文件后缀
                bufferedOutputStream.write(b, 0, b.length);

                int len = 0;
                byte[] bytes = new byte[2048];
                while ((len = is.read(bytes)) != -1) {
                    // 写文件
                    bufferedOutputStream.write(bytes, 0, bytes.length);
                    bufferedOutputStream.flush();
                }
                System.out.println("接收完了");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedOutputStream.close();
                fos.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static String checkType(String xxxx) {

        switch (xxxx) {
            case "FFD8FF": return "jpg";
            case "89504E": return "png";
            case "474946": return "gif";

            default: return "0000";
        }
    }
}
