/**
* ClassName : TestNull.java
* Create on ：2016年11月9日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@foxmail.com
*/
package com.spring.mvc.test;

import org.junit.Test;

public class TestNull {
    @Test
    public void testNull(){
        String s = new String();
        //System.out.println(s == "s");
        
        Integer integer = null;
        //System.out.println(integer == 3);
        System.out.println(integer == null);
    }
}
