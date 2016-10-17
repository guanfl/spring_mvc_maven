/**
* ClassName : UserNewValidator.java
* Create on ：2016年10月17日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@foxmail.com
*/
package com.spring.mvc.web.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.mvc.entity.UserNew;

/**自定义验证器*/
public class UserNewValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserNew.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "id", null, "id is empty.");
        UserNew user = (UserNew) target;  
        if (null == user.getPassword() || "".equals(user.getPassword()))  
            errors.rejectValue("password", null, "Password is empty.");
    }


}
