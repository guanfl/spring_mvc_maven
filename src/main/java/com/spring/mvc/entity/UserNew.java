package com.spring.mvc.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;

@XmlRootElement(name="usernew")
public class UserNew {
    //@NotNull(message="#{message['USER_ID_IS_NULL']}")
    @NotNull(message="{USER_ID_IS_NULL}")
    private Integer id;
    //使用EL表达式来取值
    @NotEmpty(message = "{user.name.null}")
    //@Length(min = 5, max = 20, message = "xxxxxxxxxxxxxxx") 
    @Value("{user.name.length.illegal}")
    private String name;
    @Value("{user.name.null}")
    private String password;
    
    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "UserNew [id=" + id + ", name=" + name + ", password=" + password + ", createtime=" + createtime + "]";
    }
}