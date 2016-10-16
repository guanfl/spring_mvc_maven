/**
* ClassName : IPLocationUtil.java
* Create on ：2016年9月21日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.util.iplocation;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.mvc.entity.IPLocationResult;

/** IP城市定位工具类
 * 使用Taobao定位信息接口信息
 * */
public class IPLocationUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(IPLocationUtil.class);
    private static final String TAOBAO_IP_API= "http://ip.taobao.com/service/getIpInfo.php?ip=";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将淘宝IP映射接口，转换为对象
     * @param ip
     * @return IPLocationResult
     */
    public static IPLocationResult getIPLocationResult(String ip) {
        //浏览器
        CloseableHttpClient client = HttpClients.createDefault();
        //数据URL地址
        HttpGet get = new HttpGet(TAOBAO_IP_API + ip);
        try {
            CloseableHttpResponse response = client.execute(get);
            StatusLine status = response.getStatusLine();
            //HttpStatus为HttpClient中的状态码
            if(status.getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = response.getEntity();
                InputStream in = entity.getContent();
                //反序列化
                IPLocationResult location = MAPPER.readValue(in, IPLocationResult.class);
                LOGGER.debug(location.toString());
                return location;
            }
            LOGGER.error("REQUEST FAILED!!" + " HTTPCODE: " + status.getStatusCode() + " REASON:" + status.getReasonPhrase());
        } catch (ClientProtocolException e) {
            LOGGER.error("Signals an error in the HTTP protocol.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        IPLocationUtil.getIPLocationResult("122.49.20.247");
    }
}
