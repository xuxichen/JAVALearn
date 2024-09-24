package com.Network.TCPFileMutilUpload;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
//        singleImgUpload();
        multiImgUpload();
    }

    private static void multiImgUpload() {
        FileInputStream fis = null;
        BufferedInputStream bufferedInputStream = null;

        Socket socket = null;
        OutputStream os = null;

        File file = new File("/Users/xuxc19/Desktop/deleted/小程序图");
        File[] list = file.listFiles();

        try {
            for (File img : list) {
                fis = new FileInputStream(img);
                bufferedInputStream = new BufferedInputStream(fis);

                socket = new Socket("127.0.0.1", 8888);
                os = socket.getOutputStream();

                int len = 0;
                byte[] bytes = new byte[1024];
                while ((len = bufferedInputStream.read(bytes)) != -1) {
                    os.write(bytes, 0, bytes.length);
                    os.flush();
                }
                socket.shutdownOutput();//标记结束
                System.out.println(img.getName()+"上传完了");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

    private static void singleImgUpload() {

        FileInputStream fis = null;
        BufferedInputStream bufferedInputStream = null;

        Socket socket = null;
        OutputStream os = null;

        try {
            fis = new FileInputStream("/Users/xuxc19/Desktop/deleted/小程序图/down2.png");
            bufferedInputStream = new BufferedInputStream(fis);

            socket = new Socket("127.0.0.1", 8888);
            os = socket.getOutputStream();

            int len = 0;
            byte[] bytes = new byte[2048];
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                os.write(bytes, 0, bytes.length);
                os.flush();
            }
            socket.shutdownOutput();//标记结束
            System.out.println("上传完了");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
