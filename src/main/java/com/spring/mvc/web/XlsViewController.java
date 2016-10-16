/**
* ClassName : XlsViewController.java
* Create on ：2016年5月30日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.entity.User;
import com.spring.mvc.web.views.ExcelViewResolver;
import com.spring.mvc.web.views.UserExcelView;

@RequestMapping("/xlsview")
@Controller
public class XlsViewController {
    private static Logger logger = LoggerFactory.getLogger(XlsViewController.class);
    
    @Autowired
    private ExcelViewResolver viewResolver;
    @Autowired
    private UserExcelView userExcelView;
    
    @RequestMapping(value="/export", method=RequestMethod.GET)
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("=========================>RUNNING HERE=====================>");
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("wordlist",list);
        
        return new ModelAndView(viewResolver ,map);
    }
    
    @RequestMapping(value="/user_export", method=RequestMethod.GET)
    public ModelAndView userExcelExport(){
        User user = new User();
        user.setId(90);
        user.setCreated(new Date());
        user.setBirthday(new Date());
        user.setAge(88);
        user.setName("xx");
        user.setSex(9);
        user.setUpdated(new Date());
        user.setUserName("shssisi");
        
        User user2 = new User();
        user2.setId(90);
        user2.setCreated(new Date());
        user2.setBirthday(new Date());
        user2.setAge(88);
        user2.setName("xx");
        user2.setSex(9);
        user2.setUpdated(new Date());
        user2.setUserName("shssisi");
        
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        Map<String,List<User>> map = new HashMap<String,List<User>>();
        map.put("userList",userList);
        return new ModelAndView(userExcelView,map);
    }

}
