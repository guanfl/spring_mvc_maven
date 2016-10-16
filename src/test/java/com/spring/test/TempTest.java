/**
* ClassName : TempTest.java
* Create on ：2016年10月16日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@foxmail.com
*/
package com.spring.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

public class TempTest {

    @Test
    public void test() {
        try {
            InetAddress inet = InetAddress.getLocalHost();

            System.out.println(inet.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
