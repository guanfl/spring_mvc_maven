/**
* ClassName : RequestValidateInterceptor.java
* Create on ：2016年10月8日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@foxmail.com
*/
package com.spring.mvc.web.interceptor;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.mvc.util.RegexpUtils;
import com.spring.mvc.util.RemoteIPUtil;
import com.spring.mvc.util.SignatureUtil;

/**公共参数请求验证拦截器
 * @version 1.0
 * @author guanfl
 */
public class RequestValidateInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestValidateInterceptor.class);
    
    @SuppressWarnings("unused")
    private static final String SWITCH_ON = "ON";
    /**验证开关*/
    private static final String SWITCH_OFF = "OFF";
    private static final String STRING_FILE = "config/env";
    /**版本号*/
    private static final String PARAM_VERSION = "v";
    /**时间戳*/
    private static final String PARAM_TEMPSTAMP = "timestamp";
    /**签名*/
    private static final String PARAM_SIGNATURE = "sign";
    
    private static final ResourceBundle resource = ResourceBundle.getBundle(STRING_FILE);
    private static final ObjectMapper JACKSON_MAPPER = new ObjectMapper();
    /**超时限制*/
    private static final long INTERVAL_MILLIS = 1L * 60L * 1000L;  
    
    /**
     * 返回失败消息
     * @param resultMap
     * @param code
     * @param reason
     */
    public void setFailureReslutMap(Map<String,Object> resultMap,HttpStatus code,String reason){
        resultMap.put("httpCode", code.value());
        resultMap.put("msg", code.getReasonPhrase());
        resultMap.put("reason", reason);
        resultMap.put("timestamp", System.currentTimeMillis());
    }
    
    /**
     * 是否跳过验证
     * @return true when need validation,otherwise return false;
     */
    private boolean skip(){
        String switchKey = resource.getString("requst.validation.switch");
        if(StringUtils.isEmpty(switchKey) || StringUtils.equals(switchKey, SWITCH_OFF))
            return true;
        return false;
    }
    
    /**
     * 签名验证业务处理
     * @param paramMap 输入参数
     * @param resultMap 输出参数
     * @return true or false
     */
    private boolean verifyRequestParams(Map<String,String> paramMap, Map<String,Object> resultMap){

        if(!paramMap.containsKey(PARAM_VERSION) || StringUtils.isEmpty(paramMap.get(PARAM_VERSION))){
            setFailureReslutMap(resultMap,HttpStatus.NOT_FOUND, "request need paramter " + PARAM_VERSION);
            return false;
        }
        
        if(!RegexpUtils.isRegexpValidated(paramMap.get(PARAM_VERSION), RegexpUtils.NON_NEGATIVE_INTEGERS_REGEXP)){
            setFailureReslutMap(resultMap,HttpStatus.BAD_REQUEST, "非法参数，版本号参数v不是正整数！！");
            return false;
        }
        
        if(!paramMap.containsKey(PARAM_TEMPSTAMP) || StringUtils.isEmpty(paramMap.get(PARAM_TEMPSTAMP))){
            setFailureReslutMap(resultMap,HttpStatus.NOT_FOUND, "request need paramter " + PARAM_TEMPSTAMP);
            return false;
        }
        
        try {
            if((System.currentTimeMillis() - Long.parseLong(paramMap.get(PARAM_TEMPSTAMP).trim())) > INTERVAL_MILLIS){
                setFailureReslutMap(resultMap,HttpStatus.REQUEST_TIMEOUT, "请求超时");
                return false;
            }
        } catch (NumberFormatException e1) {
            setFailureReslutMap(resultMap,HttpStatus.BAD_REQUEST, "非法参数，timestamp不是数字！！");
            return false;
        }
        
        if(!paramMap.containsKey(PARAM_SIGNATURE) || StringUtils.isEmpty(paramMap.get(PARAM_SIGNATURE))){
            setFailureReslutMap(resultMap,HttpStatus.NOT_FOUND, "request need paramter " + PARAM_SIGNATURE);
            return false;
        }
        //验证签名
        try {
            String sign = SignatureUtil.signTopRequest(paramMap, "MD5");
            if(!paramMap.get(PARAM_SIGNATURE).equals(sign)){
                setFailureReslutMap(resultMap,HttpStatus.BAD_REQUEST, "非法参数，签名有误！！！");
                return false;
            }
        } catch (NoSuchAlgorithmException e) {
            setFailureReslutMap(resultMap,HttpStatus.BAD_REQUEST, "不支持当前方法签名");
            return false;
        } catch (IOException e) {
            setFailureReslutMap(resultMap,HttpStatus.BAD_REQUEST, "内部编码错误");
            return false;
        }
        return true;
    }
    
    /**
     * 处理请求参数Map
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    private Map<String,String> getParameterMap(HttpServletRequest request){
        Map<String,String> paramsMap = new HashMap<>();
        
        Map<String,String[]> tempMap = request.getParameterMap();
        for(Entry<String,String[]> entry : tempMap.entrySet()){
            String[] value = entry.getValue();
            String key = entry.getKey();
            paramsMap.put(key, StringUtils.join(value, ","));
        }
        return paramsMap;
    }
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //skip validate
        if(skip()) return true;
        
        Map<String,String> paramMap = getParameterMap(request);
        Map<String,Object> resultMap = new HashMap<>();
        //验证未通过
        if(!verifyRequestParams(paramMap,resultMap)){
            Map<String,Object> temp = new HashMap<>();
            temp.put("error_response", resultMap);
            JACKSON_MAPPER.writeValue(response.getOutputStream(), temp);
            //记录非法访问者IP
            try {
                LOGGER.error("Invalid Request from : " + RemoteIPUtil.getUserRealIP(request) + " for "  + request.getRequestURI());
            } catch (Exception e) {}
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // do nothing
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // do nothing
    }

}
