/**
* ClassName : UserNewLinked.java
* Create on ：2016年10月30日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@foxmail.com
*/
package com.spring.mvc.entity.linked;

import java.util.List;

import com.spring.mvc.entity.Group;
import com.spring.mvc.entity.UserNew;

/**关联关系*/
public class UserNewLinked extends UserNew {
    List<Group> groups;

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return super.toString() + "UserNewLinked [groups=" + groups + "]";
    }
}
