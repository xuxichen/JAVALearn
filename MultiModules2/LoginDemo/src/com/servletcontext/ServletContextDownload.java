package com.servletcontext;

import com.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet("/servletdownload")
public class ServletContextDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取文件名
        String filename = req.getParameter("filename");

        System.out.println(filename);
        // 获取servletContext
        ServletContext servletContext = this.getServletContext();
        // 获取文件真实路径realPath
        String realPath = servletContext.getRealPath("/img/" + filename);

        // 创建字节流
        FileInputStream fileInputStream = new FileInputStream(realPath);

        // 获取文件的mimeType
        String mimeType = servletContext.getMimeType(filename);
        resp.setCharacterEncoding("utf-8");
        // 设置响应头context-type
        resp.setHeader("content-type", mimeType);
        // 获取user-agent请求头
        String agent = req.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent, filename);
        //设置响应头打开方式
        resp.setHeader("content-disposition", "attachment;filename="+filename);
        // 获取response 字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] buff = new byte[1024*8];
        int len = 0;
        while ((len = fileInputStream.read(buff)) != -1) {
            // 写入输出流
            outputStream.write(buff, 0, len);
        }
        fileInputStream.close();
    }
}
