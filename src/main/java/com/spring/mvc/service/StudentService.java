/**
* ClassName : StudentService.java
* Create on ：2016年3月22日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.StudentDao;
import com.spring.mvc.entity.Student;

@Service
public class StudentService {
	private static Logger logger = Logger.getLogger(StudentService.class);
	@Autowired
	private StudentDao dao;
	
	public Student selectStudentById(int id){
		logger.debug("start get");
		return dao.selectByID(id);
	}
	
	public List<Student> selectAllStudent(){
	    logger.debug("********select all student*********");
		return dao.selectAllStu();
	}
	
	public void insertStudent(Student stu){
	    logger.debug("***************insert student**************");
		dao.insertStudent(stu);
	}
	
	public void editStuent(Student stu){
	    logger.debug("******edit student*********");
		dao.edit(stu);
	}
}
