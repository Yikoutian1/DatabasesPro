package com.hang.domain.dto.entity;

import java.io.Serializable;

/**
 * (SalInfo)实体类
 *
 * @author makejava
 * @since 2023-12-05 19:37:57
 */
public class SalInfo implements Serializable {
    private static final long serialVersionUID = 276693601989433003L;
    
    private Integer empId;
    /**
     * 员工姓名
     */
    private String empName;
    /**
     * 员工基础工资
     */
    private Double baseSalary;
    /**
     * 员工岗位工资
     */
    private Double jobSalary;
    /**
     * 员工工龄工资
     */
    private Double expSalary;
    /**
     * 公司福利
     */
    private Double companyBenefits;
    /**
     * 员工实得工资
     */
    private Double netSalary;


    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(Double jobSalary) {
        this.jobSalary = jobSalary;
    }

    public Double getExpSalary() {
        return expSalary;
    }

    public void setExpSalary(Double expSalary) {
        this.expSalary = expSalary;
    }

    public Double getCompanyBenefits() {
        return companyBenefits;
    }

    public void setCompanyBenefits(Double companyBenefits) {
        this.companyBenefits = companyBenefits;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }

}

