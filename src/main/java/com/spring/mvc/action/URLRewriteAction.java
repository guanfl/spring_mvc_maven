/**
* ClassName : URLRewriteAction.java
* Create on : 2016年8月4日
* Author : guanfl
* Email : guanfl@ifeng.com
* Copyright 2016 ifeng.com All Rights Reserved
*/
package com.spring.mvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/urlrewrite")
public class URLRewriteAction {
    @RequestMapping(value="/testurl",method=RequestMethod.GET)
    public Object testURL(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return null;
    }
}
