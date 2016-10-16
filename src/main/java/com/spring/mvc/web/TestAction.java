/**
* ClassName : TestAction.jareva
* Create on ：2016年7月1日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mvc.dao.IUserMapper;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/test")
public class TestAction {
    @Autowired
    private IUserMapper mapper;
    
    @RequestMapping("/redirect")
    public void sendRedirectRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String message = "message";
        //request.getSession().setAttribute(message, "hello");
        
        //request.setAttribute(message, "requestMessage.");
        String refer=request.getHeader("refer");
        System.out.println("refer>>>"+refer);
        request.setAttribute(message, message);
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
    
    @ResponseBody
    @RequestMapping(value="/json",method=RequestMethod.GET)
    public Object returnJsonTest(){
        return mapper.selectAllIUsers();
    }
    
    /**
     * 根据用户名获取用户对象
     * @param name
     * @return
     */
    @RequestMapping(value="/name/{path}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据用户名获取用户对象", httpMethod = "GET", response = Object.class, notes = "根据用户名获取用户对象")
    public Object getUserByName(@ApiParam(required = true, name = "name", value = "用户名") @PathVariable String name) throws Exception{
        return mapper.selectAllIUsers();
    }
}
