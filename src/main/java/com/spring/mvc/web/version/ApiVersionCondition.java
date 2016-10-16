/**
* ClassName : ApiVersionCondition.java
* Create on ：2016年10月12日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@foxmail.com
*/
package com.spring.mvc.web.version;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

/**版本条件*/
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {
    /**路径中版本的前缀， 这里用 /v[1-9]/的形式*/
    private static final Pattern VERSION_PREFIX_PATTERN = Pattern.compile("^(\\d+)$")/*compile("^(\\d+)(\\.\\d+)?$")*/;
    
    private int apiVersion;
    
    public ApiVersionCondition(int apiVersion){
        this.apiVersion = apiVersion;
    }
    
    @Override
    public ApiVersionCondition combine(ApiVersionCondition other) {
        return new ApiVersionCondition(other.getApiVersion());
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
        String v = request.getParameter("v");
        //无版本号
        if(null == v || v.trim().equals("")) return null;
        
        Matcher matcher = VERSION_PREFIX_PATTERN.matcher(v);
        //匹配
        if(matcher.matches()){
           int version = Integer.valueOf(v);
           if(version >= this.apiVersion)       //如果请求的版本号大于配置的版本号，则满足
               return this;
        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionCondition other, HttpServletRequest request) {
        // 优先匹配最新的版本
        return other.getApiVersion() - this.getApiVersion();
    }
    
    public int getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(int apiVersion) {
        this.apiVersion = apiVersion;
    }
}
