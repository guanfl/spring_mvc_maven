/**
* ClassName : User.java
* Create on ：2016年6月22日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.entity;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//注解：Expose用于区分是否需要序列化
//Expose有两个属性serialize
//还有一个deserialize 均是boolean值 一个是序列化另一个是反序列化
//@SerializedName注解 : 是设置序列化之后字段的名称==>别名
public class User /* implements Serializable */ {
    @Expose
    private String username;
    @Expose(serialize=false)
    private int age;
    @Expose
    @SerializedName(value="Handsome")
    private List<String> list;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
    
    
    public static void main(String args[]){
        User user = new User("zhag", 12);
        List<String> list = new ArrayList<String>();
        list.add("shi");
        list.add("shso");
        list.add("shi");
        list.add("shso");
        list.add("shi");
        list.add("shso");
        user.setList(list);
        
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()//不生成没有expose注解的字段
                .create();
        String json = gson.toJson(user);
        System.out.println(json);
        
    }
}
