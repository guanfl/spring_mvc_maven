/**
* ClassName : IpLocationMapping.java
* Create on ：2016年9月21日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.iplocation;

import java.io.Serializable;

public class IpLocationMapping implements Serializable{
    private static final long serialVersionUID = 484657759125057430L;
    private String country;
    private String country_id;
    private String area;
    private Integer area_id;
    private String region;
    private Integer region_id;
    private String city;
    private Integer city_id;
    private String county;
    private Integer county_id;
    private String isp;
    private Integer isp_id;
    private String ip;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Integer region_id) {
        this.region_id = region_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getCounty_id() {
        return county_id;
    }

    public void setCounty_id(Integer county_id) {
        this.county_id = county_id;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public Integer getIsp_id() {
        return isp_id;
    }

    public void setIsp_id(Integer isp_id) {
        this.isp_id = isp_id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "IpLocationMapping [country=" + country + ", country_id=" + country_id + ", area=" + area + ", area_id=" + area_id + ", region=" + region + ", region_id=" + region_id + ", city=" + city + ", city_id=" + city_id + ", county=" + county + ", county_id=" + county_id + ", isp=" + isp + ", isp_id=" + isp_id + ", ip=" + ip + "]";
    }
}
