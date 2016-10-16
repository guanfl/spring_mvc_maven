/**
* ClassName : DynamicDataSourceHolder.java
* Create on : 2016年8月16日
* Author : guanfl
* Email : guanfl@ifeng.com
* Copyright 2016 ifeng.com All Rights Reserved
*/
package com.spring.mvc.dao.datasource;

public class DynamicDataSourceHolder {
    //写库对应的数据源key
    private static final String MASTER = "master";
    //读库对应的数据源key
    private static final String SLAVE = "slave";
    //使用ThreadLocal记录当前线程的数据源key
    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();
    
    /**
     * 设置数据源key
     * @param key
     */
    public static void putDataSourceKey(String key){
        dataSourceKey.set(key);
    }
    
    /**
     * 获取数据源key
     * @return
     */
    public static String getDataSourceKey(){
        //返回此线程相关的值
        return dataSourceKey.get();
    }
    
    /**
     * 标记写库
     */
    public static void markMaster(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>MASTER>>>>>>>>>>>>>");
        putDataSourceKey(MASTER);
    }
    
    /**
     * 标记读库
     */
    public static void markSlave(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>SLAVE>>>>>>>>>>>>>");
        putDataSourceKey(SLAVE);
    }

}
