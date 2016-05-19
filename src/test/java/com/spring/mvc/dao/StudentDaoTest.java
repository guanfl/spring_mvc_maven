/**
* ClassName : StudentDaoTest.java
* Create on ：2016年3月22日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.mvc.entity.Student;
import com.spring.mvc.service.StudentService;

public class StudentDaoTest {
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void testSelectStudents(){
		System.out.println("test select student");
		StudentService service = (StudentService)context.getBean("service");
		List<Student> list = service.selectAllStudent();
		System.out.println("SIZE : " + list.size());
		for(Student s : list){
			System.out.println(s);
		}
	}
	
	@Test
	public void testSelectStudentById(){
		StudentService service = (StudentService)context.getBean("service");
		System.out.println(service.selectStudentById(2));
	}
	
	@Test
	public void testInsertStudetn(){
		StudentService service = (StudentService)context.getBean("service");
		Student s = new Student();
		s.setName("liudong");
		s.setBrithday(new Date());
		s.setScore(99.0);
		service.insertStudent(s);
	}
}
