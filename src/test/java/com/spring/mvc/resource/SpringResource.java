/**
* ClassName : SpringResource.java
* Create on ：2016年9月29日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.resource;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**Spring Core Resource接口测试*/
public class SpringResource {

    @Test
    public void testSpringResouce() {
        // FileSystemResouce
        // ClassPathResouce
        // ServletContextResouce
        try {
            String filePath = "D:\\file.log.2016-09-27.log";
            // 系统文件路径的方式加载文件
            Resource res1 = new FileSystemResource(filePath);
            Resource res2 = new ClassPathResource("log4j.properties");

            InputStream inputStream1 = res1.getInputStream();
            InputStream inputStream2 = res2.getInputStream();
            
            String fileName1 = res1.getFilename();
            String fileName2 = res2.getFilename();
            
            System.out.println(fileName1 + "\n" + fileName2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
