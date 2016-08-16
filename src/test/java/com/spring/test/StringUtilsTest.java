/**
* ClassName : StringUtilsTest.java
* Create on ：2016年6月30日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;


public class StringUtilsTest {
    @Test
    public void testReplaceString(){
        String text = "新增系统用户{0}";
        String destString = StringUtils.replace(text, "{0}", "user");
        System.out.println(destString);
    }
}
