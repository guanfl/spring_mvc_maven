/**
* ClassName : IPLocationResult.java
* Create on ：2016年9月21日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.iplocation;

import java.io.Serializable;

public class IPLocationResult implements Serializable {
    private static final long serialVersionUID = -4397884872024811437L;
    private int code;
    private IpLocationMapping data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public IpLocationMapping getData() {
        return data;
    }

    public void setData(IpLocationMapping data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IPLocationResult [code=" + code + ", data=" + data + "]";
    }
}
