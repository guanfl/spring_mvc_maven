/**
* ClassName : ResourceInternationalized.java
* Create on : 2016年8月15日
* Author : guanfl
* Email : guanfl@ifeng.com
* Copyright 2016 ifeng.com All Rights Reserved
*/
package com.spring.mvc.util.international;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceInternationalized {
    // how to use resourceBundle to get international information;
    public static void main(String[] args) {
        //使用指定的基本名称、默认的语言环境和资源包基本名称，来获取资源包；
        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n/messages",new Locale("en"));
        /// ResourceBundleMessageSource resourceBundleMessageSource;
        String email = resourceBundle.getString("LOGIN_FAIL");//根据指定的key获取国际化数据
        System.out.println(email);
    }
}
