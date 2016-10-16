/**
* ClassName : UserAction.java
* Create on ：2016年3月23日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user.htm")
public class UserAction {
    
    @RequestMapping(params={"method=list"})
    public ModelAndView list(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        System.out.println("UserController.list()-------------------");
        String method = (String) req.getAttribute("test");
        System.out.println(method);
        resp.getWriter().write("<h1>Hello Moto</h1>");
        return null;
        //return new ModelAndView("user_list");
    }
    
    @RequestMapping(params={"method=add"})
    public ModelAndView add(){
        System.out.println("UserController.add()======================");
        return new ModelAndView("user_list");
    }
    
    @RequestMapping(params={"method=delete"})
    public ModelAndView delete(@RequestParam int id){
        System.out.println("UserController.delete():  id=" + id);
        return new ModelAndView("user_list");
    }
}

