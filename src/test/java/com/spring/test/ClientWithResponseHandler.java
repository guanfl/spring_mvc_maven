/**
* ClassName : ClientWithResponseHandler.java
* Create on ：2016年7月1日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.test;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ClientWithResponseHandler {
    public final static void main(String[] args){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        
        HttpGet httpGet = new HttpGet("http://httpbin.org");
        System.out.println("Executing request " + httpGet.getRequestLine());
        
    }
}
