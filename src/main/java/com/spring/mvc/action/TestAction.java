/**
* ClassName : TestAction.jareva
* Create on ：2016年7月1日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestAction {
    @RequestMapping("/redirect")
    public void sendRedirectRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String message = request.getParameter("message");
        //request.getSession().setAttribute(message, "hello");
        
        //request.setAttribute(message, "requestMessage.");
        String refer=request.getHeader("refer");
        System.out.println("refer>>>"+refer);
        
        //dispatcher中使用的是相对路径
        request.getServletContext().getRequestDispatcher("/hello.jsp").forward(request, response);;
        //The pathname must begin with a / and is interpreted as relative to the current context root
        
        //response.setContentType("text/html; charset=utf-8");
        //response.sendRedirect(/*request.getContextPath()+ "/hello.jsp"*/"https://www.baidu.com");
        
        //恍然大悟：sendRedirect访问到的是一个绝对路径，一般请求会带上request.getContext();这样 来或去绝对路径，如果在浏览器访问配置中修改了访问路径
        //就会影响页面的使用
        
        //而更推荐使用，
        //response.setHeader("location", "/spring/hello.jsp");
        //response.setStatus(302);//moved temporarily
        //这样就是使用的一个相对路径,更利于系统优化
        
        
    }
}
