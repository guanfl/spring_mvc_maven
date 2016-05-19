/**
* ClassName : StudentDao.java
* Create on ：2016年3月22日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.mvc.entity.Student;

@Repository
public interface StudentDao {
	public Student selectByID(int id);
	public List<Student> selectAllStu();
	public void deleteStudentById(int id);
	public void edit(Student stu);
	public void insertStudent(Student stu);
}
