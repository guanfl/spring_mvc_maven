/**
* ClassName : SerializeStudentToByteArray.java
* Create on ：2016年6月22日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.entity.serialized;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import com.spring.mvc.entity.Student;

//将Student转换成Byte数组
public class SerializeStudentToByteArray {
    
    public static void main(String args[]){
        //实例化一个ByteArrayOutputStream对象，初始化capacity容量(Buffer area)大小为32,在必要时可进行扩容
        // The buffer capacity is initially 32 bytes, though its size increases if necessary.
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] byteDatas = bos.toByteArray();
        System.out.println(byteDatas.length);
        
        
        //Student entity
        Student stu = new Student();
        stu.setId(110);
        stu.setName("zhangsan");
        stu.setScore(12.90);
        stu.setBrithday(new Date());
        
        try {
            /*DataOutputStream dos = new DataOutputStream(bos);
            dos.writeBytes("String data");
            byte[] bdata = bos.toByteArray();
            System.out.println("size  " + bdata.length);
            for(byte b : bdata){
                System.out.println(">>>" + (char)b);
            }*/
            
            System.out.println("============================");
            
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(stu); //将对象写入ByteOutputStream流当中
            byte[] byteObj = bos.toByteArray(); //将bos转换成byte数组
            int size = bos.size();//return the current size of the buffer
            System.out.println("SIZE==>" + size);
            
            System.out.println("After serialized SIZE: " + byteObj.length);
            for(byte b : byteObj){
                System.out.print((char)b);
            }
            
            System.out.println("-----------separate---line----------");
            FileOutputStream fos = new FileOutputStream(new File("D:/student.txt"));
            @SuppressWarnings("resource")
            ObjectOutputStream oos2 = new ObjectOutputStream(fos);
            oos2.writeObject(stu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
