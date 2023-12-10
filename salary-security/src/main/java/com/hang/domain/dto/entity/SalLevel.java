package com.hang.domain.dto.entity;

import java.io.Serializable;

/**
 * (SalLevel)实体类
 *
 * @author makejava
 * @since 2023-12-05 19:37:57
 */
public class SalLevel implements Serializable {
    private static final long serialVersionUID = 447643049777264938L;
    /**
     * 工资级别
     */
    private String salGrade;
    /**
     * 工资金额
     */
    private Double salAmount;


    public String getSalGrade() {
        return salGrade;
    }

    public void setSalGrade(String salGrade) {
        this.salGrade = salGrade;
    }

    public Double getSalAmount() {
        return salAmount;
    }

    public void setSalAmount(Double salAmount) {
        this.salAmount = salAmount;
    }

}

