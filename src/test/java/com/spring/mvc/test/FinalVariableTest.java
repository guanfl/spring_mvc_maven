/**
* ClassName : FinalVariableTest.java
* Create on ：2016年11月3日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@foxmail.com
*/
package com.spring.mvc.test;

import org.junit.Test;

public class FinalVariableTest {
    
    public /*final*/ void testFinal(){
        final StringBuilder sb = new StringBuilder("REDIS_KEY_DEALERINFOLISTBYIDDEFAULT_");
        sb.append("brandId").append("_");
        sb.append("corpId").append("_");
        sb.append("serialId").append("_");
        sb.append("carId").append("_");
        sb.append("all").append("_");
        sb.append("areaCode").append("_");
        sb.append("companyType").append("_");
        sb.append("is400").append("_");
        sb.append("isFee").append("_");
        sb.append("serialPageNews").append("_");
        sb.append("pageNum").append("_");
        sb.append("pageSize").append("_");
        sb.append("sort");
        
        System.out.println(Thread.currentThread().getName() + "...." + sb.hashCode());
    }
    
    @Test
    public void testFinalTwo(){
        testFinal();
        
        new Thread(){
            @Override
            public void run() {
                testFinal();
            }
            
        }.start();
        
        //1、局部变量使用final修饰并不能改变生命周期
        //2、final的存在是保证变量的一致性
        //3、每次调用的时候都会重新生成一遍
    }
}
