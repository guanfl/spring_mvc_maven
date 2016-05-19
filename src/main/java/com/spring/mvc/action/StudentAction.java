/**
* ClassName : StudentAction.java
* Create on ：2016年3月22日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentAction {

    @RequestMapping(value="/hello",method=RequestMethod.GET)
    public ModelAndView helloStudent(Model model) {
        // 1、收集参数
        // 2、绑定参数到命令对象
        // 3、调用业务对象
        // 4、选择下一个页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","你好，同学！");
        mv.setViewName("hello");
        System.out.println("================>");
        return mv;
    }
}
