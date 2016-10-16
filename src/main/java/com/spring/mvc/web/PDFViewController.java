/**
* ClassName : XlsViewController.java
* Create on ：2016年5月30日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.web;

import java.util.ArrayList;
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
import org.springframework.web.servlet.mvc.AbstractController;

import com.spring.mvc.web.views.PDFViewResolver;

@RequestMapping("/pdf")
@Controller
public class PDFViewController extends AbstractController {
    private static Logger logger = LoggerFactory.getLogger(PDFViewController.class);
    
    @Autowired
    private PDFViewResolver pdfResolver;

    @Override
    @RequestMapping(value="/view", method=RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("=========================>RUNNING HERE=====================>");
        List<String> list = new ArrayList<>();
        list.add("这是一段PDF文字");
        list.add("这是一段PDF文字");
        list.add("这是一段PDF文字");
        list.add("这是一段PDF文字");
        list.add("这是一段PDF文字");
        list.add("这是一段PDF文字");
        list.add("这是一段PDF文字");
        list.add("这是一段PDF文字");
        list.add("这是一段PDF文字");
        list.add("这是一段PDF文字");
        list.add("这是一段PDF文字");
        list.add("这是一段PDF文字");
        
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("wordlist",list);
        
        return new ModelAndView(pdfResolver ,map);
    }

}
