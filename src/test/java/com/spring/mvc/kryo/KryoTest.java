/**
* ClassName : KryoTest.java
* Create on ：2016年11月3日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@foxmail.com
*/
package com.spring.mvc.kryo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.spring.mvc.entity.Student;

public class KryoTest {
    
    public static void main(String args[]) throws FileNotFoundException{
        Kryo kryo = new Kryo();
        Output output = new Output(new FileOutputStream("file.bin"));
        //object to be serialized
        Student student =  new Student();
        
        student.setArea("12e322");
        student.setBrithday(new Date());
        student.setId(923);
        student.setName("hello kitty");
        student.setScore(90.90);
        kryo.writeObject(output, student);
        output.close();
        
        Input input = new Input(new FileInputStream("file.bin"));
        Student deStudent = kryo.readObject(input, Student.class);
        System.out.println(deStudent);
    }
}
