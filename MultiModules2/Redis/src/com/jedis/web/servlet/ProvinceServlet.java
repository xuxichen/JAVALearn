package com.jedis.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jedis.domain.Province;
import com.jedis.service.ProvinceService;
import com.jedis.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取省份数据
        ProvinceService provinceService = new ProvinceServiceImpl();
//        List<Province> provinces = provinceService.finAll();
//
//        // 2、序列化list为json
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(provinces);

        String json = provinceService.finAllJson();

        // 3、响应结果
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }
}
