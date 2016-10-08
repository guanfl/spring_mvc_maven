/**
* ClassName : TestStudent.java
* Create on ：2016年3月22日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.test;

import java.util.Date;

import org.junit.Test;

import com.spring.mvc.entity.Student;

public class TestStudent {

	@Test
	public void testSout(){
		Student s = new Student();
		s.setBrithday(new Date());
		s.setId(1);
		s.setName("zhangsan");
		s.setScore(90.00);
		System.out.println(s);
	}
}
