/**
* ClassName : UserNewController.java
* Create on ：2016年10月16日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@foxmail.com
*/
package com.spring.mvc.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mvc.entity.UserNew;
import com.spring.mvc.service.UserNewService;
import com.spring.mvc.web.common.BaseController;

@Controller
@RequestMapping("user_new")
public class UserNewController extends BaseController {
    @Autowired
    private UserNewService service;
    
    @ResponseBody
    @RequestMapping(value="{id}",method=RequestMethod.GET)
    public ResponseEntity<ModelMap> user(@PathVariable Integer id, ModelMap modelMap) throws Exception{
        return this.setSuccessModelMap(modelMap,service.getUserNew(id));
    }
    
    /**BindingResult&&Valid
     * 绑定与验证
     * */
    @ResponseBody
    @RequestMapping("user")
    public Object userNewRequest(@Valid UserNew user, BindingResult result){
        Map<String,Object> resultMap = new HashMap<>();
        if(result.hasErrors()){
            resultMap.put("msg", "binging errors");
            List<ObjectError> list = result.getAllErrors();
            for(ObjectError oe : list){
                resultMap.put("reason" , oe.getDefaultMessage());
            }
            return resultMap;
        }
        return user;
    }
    
    @ResponseBody
    @RequestMapping(value="validator",method=RequestMethod.GET)
    //@Validated
    public Object annotaionValidator(@Valid UserNew user, BindingResult result){
        Map<String,Object> resultMap = new HashMap<>();
        if(result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            List<String> errorMsgList = new ArrayList<>();
            for(ObjectError e : errors){
                String errorMessage = e.getDefaultMessage();
                errorMsgList.add(errorMessage);
            }
            resultMap.put("errors", errorMsgList);
            return resultMap;
        }
        return user;
    }
    
}
