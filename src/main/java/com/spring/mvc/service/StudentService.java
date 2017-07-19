/**
* ClassName : StudentService.java
* Create on ：2016年3月22日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.StudentDao;
import com.spring.mvc.entity.Student;

@Service
public class StudentService {
    // 不使用具体的日志实现类jar而使用接口，和抽象工厂方法模型
    private static Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentDao    dao;

    public Student selectStudentById(int id) {
        logger.debug("start get");
        return dao.selectByID(id);
    }

    public List<Student> selectAllStudent() {
        logger.debug("********select all student*********");
        return dao.selectAllStu();
    }

    public void insertStudent(Student stu) {
        logger.debug("***************insert student**************");
        dao.insertStudent(stu);
    }

    public void editStuent(Student stu) {
        logger.debug("******edit student*********");
        dao.edit(stu);
    }
}
