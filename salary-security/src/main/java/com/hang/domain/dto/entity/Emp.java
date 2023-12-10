package com.hang.domain.dto.entity;

import java.io.Serializable;

/**
 * (Emp)实体类
 *
 * @author makejava
 * @since 2023-12-05 19:37:09
 */
public class Emp implements Serializable {
    private static final long serialVersionUID = -17439178181596187L;
    
    private Integer id;
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 性别: 1男性(默认) 0女性
     */
    private String sex;
    /**
     * 所在部门
     */
    private String dept;
    /**
     * 工资级别
     */
    private String salJb;
    
    private String salDj;


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
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSalJb() {
        return salJb;
    }

    public void setSalJb(String salJb) {
        this.salJb = salJb;
    }

    public String getSalDj() {
        return salDj;
    }

    public void setSalDj(String salDj) {
        this.salDj = salDj;
    }

}

