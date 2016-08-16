/**
* ClassName : DynamicDataSource.java
* Create on : 2016年8月16日
* Author : guanfl
* Email : guanfl@ifeng.com
* Copyright 2016 ifeng.com All Rights Reserved
*/
package com.spring.mvc.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/** 动态数据源 ，用于读写分离时切换数据源*/
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        //从当前线程中获取数据源key
        return DynamicDataSourceHolder.getDataSourceKey();
    }

}
