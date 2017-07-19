/**
 * ClassName : Configuration.java
 * Create on : 2016年3月15日
 * Author : guanfl
 * Copyrights 2016 IBM All rights reserved.
 */
package com.spring.mvc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BasicConfiguration {
	private static BasicConfiguration configuration = null;
	private Properties props = null;
	
	private BasicConfiguration() {
		reconfig();
	}
	
	public static BasicConfiguration getInstance(){
		if(configuration == null){
		    synchronized (BasicConfiguration.class){
		        if(configuration == null)//此处因为别的线程可能已经创建了
		            configuration = new BasicConfiguration();
		    }
		}
		return configuration;
	} 
	
	private void reconfig(){
		props = new Properties();
		InputStream in = null;
		@SuppressWarnings("unused")
        String userPath = System.getProperty("user.dir");
		try {
		    //System.out.println(userPath);
			in = Thread.currentThread().getContextClassLoader().getResourceAsStream( "/config.properties");
			//in = new FileInputStream(new File(userPath + "/config/config.properties"));
			if(null == in)
			    throw new IOException();
			props.load(in);
		} catch (IOException e) {
		    System.err.println("读取配置文件失败！！");
            e.printStackTrace();
            return;
        } finally{
			if(in !=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String getValue(String key){
		return props.getProperty(key).trim();
	}
	
	public static void main(String args[]){
	    BasicConfiguration.getInstance();
	}
}
