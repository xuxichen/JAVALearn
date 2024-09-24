package com.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    private List<String> list = new ArrayList<String>(); // 敏感词汇集合
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 1、加载文件
        ServletContext servletContext = filterConfig.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/keywords.txt");
        // 2、读取文件
        BufferedReader bufferedReader=null;
        try {
            bufferedReader = new BufferedReader(new FileReader(realPath));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }

            System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 3、将文件的每一行数据添加到list中

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1、创建代理对象，增强getParameter方法
        HttpServletRequest proxyInstance = (HttpServletRequest)Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")) {
                    // 增强返回值
                    String value = (String)method.invoke(servletRequest, args);
                    if (value != null) {
                        for (String str: list) {
                            if (value.contains(str)) {
                                value = value.replace(str,"***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(servletRequest, args);
            }
        });

        filterChain.doFilter(proxyInstance, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
