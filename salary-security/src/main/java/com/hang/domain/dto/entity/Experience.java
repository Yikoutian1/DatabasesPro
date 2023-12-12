package com.hang.domain.dto.entity;

import java.io.Serializable;

/**
 * (Experience)实体类
 *
 * @author makejava
 * @since 2023-12-05 19:37:57
 */
public class Experience implements Serializable {
    private static final long serialVersionUID = -36964846883548241L;
    /**
     * 工龄
     */
    private Integer exp;
    /**
     * 工资金额
     */
    private Double salAmount;


    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Double getSalAmount() {
        return salAmount;
    }

    public void setSalAmount(Double salAmount) {
        this.salAmount = salAmount;
    }

}

