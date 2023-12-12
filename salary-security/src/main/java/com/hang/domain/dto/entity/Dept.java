package com.hang.domain.dto.entity;

import java.io.Serializable;

/**
 * (Dept)实体类
 *
 * @author makejava
 * @since 2023-12-05 19:37:09
 */
public class Dept implements Serializable {
    private static final long serialVersionUID = -35619440828284607L;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 工作岗位名称
     */
    private String jobTitle;
    /**
     * 工作岗位工资
     */
    private Double jobSalary;


    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Double getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(Double jobSalary) {
        this.jobSalary = jobSalary;
    }

}

