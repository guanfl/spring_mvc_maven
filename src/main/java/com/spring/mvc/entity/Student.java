/**
* ClassName : User.java
* Create on ：2016年3月22日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
    
    private static final long serialVersionUID = 5655170335533783008L;
    private int id;
	private String name;
	private Date brithday;
	private double score;
	private String area;
	
	public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBrithday() {
		return brithday;
	}

	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", brithday=" + brithday + ", score=" + score + ", area=" + area + "]";
    }
}
