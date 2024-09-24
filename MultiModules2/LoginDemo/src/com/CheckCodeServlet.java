package com;

import com.domain.User;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("不支持？");
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int w=100;
        int h=50;

        // 1、创建一对象，在内存中图片（验证图片对象）
        BufferedImage bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        // 2、美化图片
        // 2.1 填充背景色
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.CYAN);
        graphics.fillRect(0,0,w,h);

        // 2.2画边框
        graphics.setColor(Color.pink);
        graphics.drawRect(0,0, w-1,h-1);

        // 2.3 写验证码
        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        for (int i=0; i<4; i++) {
            int anInt = random.nextInt(string.length());
            char c = string.charAt(anInt);
            graphics.drawString(c+"",20*(i+1),25);
        }

        // 2.4 画干扰线
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(w);
            int x2 = random.nextInt(w);
            int y1 = random.nextInt(h);
            int y2 = random.nextInt(h);
            graphics.drawLine(x1,y1, x2,y2);
        }

        ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());
    }
}
