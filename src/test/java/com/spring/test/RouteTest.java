/**
* ClassName : RouteTest.java
* Create on ：2016年6月30日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.entity.Student;
import com.spring.mvc.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class RouteTest {
    @Autowired
    private SqlSessionFactory sessionFactory;
    
    @Autowired
    private StudentService studentService;

    private SqlSession session;
    
    @Before
    public void beforeTest(){
        session = sessionFactory.openSession();
    }
    
    @Test
    public void queryDb() {
        Student stu = new Student();
        stu.setBrithday(new Date());
        stu.setId(90);
        stu.setName("ss");
        stu.setScore(89.00);
        studentService.insertStudent(stu);
    }
    
    @Test
    public void testSqlSessionFactory(){
        List<Student> list = session.selectList("com.spring.mvc.dao.StudentDao.selectAllStu");
        System.out.println(list.size());
        for(Student s : list){
            System.out.println(s);
        }
    }

}
