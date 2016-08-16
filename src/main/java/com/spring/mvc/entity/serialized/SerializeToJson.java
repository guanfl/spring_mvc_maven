/**
* ClassName : SerializeToJson.java
* Create on ：2016年6月22日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.entity.serialized;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.mvc.entity.Student;

/***
 * 将Student对象序列化成Json对象
 */
public class SerializeToJson {
    public static void main(String args[]){
        Student stu = new  Student();
        stu.setBrithday(new Date());
        stu.setId(900);
        stu.setName("exo");
        stu.setScore(11.22);
        
        //Gson gson = new Gson();
        //GsonBuilder 根据Builder生成Gson
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        String json = gson.toJson(stu);
        System.out.println(json);
    }
}
