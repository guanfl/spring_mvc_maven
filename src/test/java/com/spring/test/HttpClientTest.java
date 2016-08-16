/**
* ClassName : HttpClientTest.java
* Create on ：2016年7月1日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {
    
    public static String getLocationMethod(String requestURL, Context context){
        
        return null;
    }

    @Test
    public void httpClientGetStart(){
        String URL = "http://127.0.0.1:8080/spring/test/redirect?message=message";
        //创建客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //封装HTTPGET请求
        HttpGet httpGet = new HttpGet(URL);
        
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            
            System.out.println(">>>>>>>" + response.getStatusLine());//statuts code
            
            //do something useful with the response body
            HttpEntity entity = response.getEntity();//返回相应消息体
            EntityUtils.consume(entity);
            //保证所有实体被消费完
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
            }
        }
    }
    
    @Test
    public void httpPostRequest(){
        String URL = "http://127.0.0.1:8080/spring/test/redirect?message=message";
        //通过默认配置来创建HttpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        
        //封装httpPost请求
        //httpPost包含请求消息头，消息体
        HttpPost httpPost = new HttpPost(URL);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new org.apache.http.message.BasicNameValuePair("username","zhangsanfeng"));
        nvps.add(new org.apache.http.message.BasicNameValuePair("password","paasg"));
        //设置消息体
        CloseableHttpResponse response = null;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            //httpClient请求服务，并返回相应Response
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();//返回响应实体对象（其中包含相应消息）
            //HttpEntity 类是用作发送和接收Http message的，
            EntityUtils.consume(entity);
        } catch (Exception e) {
            throw new RuntimeException();
        } finally{
            try {
                response.close();
            } catch (IOException e) {
            }
        }
    }
}

