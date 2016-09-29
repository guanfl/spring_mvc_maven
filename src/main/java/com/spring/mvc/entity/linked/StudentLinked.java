/**
* ClassName : StudentLinked.java
* Create on ：2016年9月28日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.entity.linked;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.spring.mvc.entity.ChinaArea;
import com.spring.mvc.entity.Student;

public class StudentLinked extends Student{
    private static final long serialVersionUID = -4928419484897199060L;
    
    @JsonUnwrapped
    private ChinaArea chinaArea;

    public ChinaArea getChinaArea() {
        return chinaArea;
    }

    public void setChinaArea(ChinaArea chinaArea) {
        this.chinaArea = chinaArea;
    }

    
}
