package com.hang.domain.dto.entity;

import java.io.Serializable;

/**
 * (CompanyBenfitits)实体类
 *
 * @author makejava
 * @since 2023-12-05 19:37:06
 */
public class CompanyBenfitits implements Serializable {
    private static final long serialVersionUID = 393363990880206051L;
    /**
     * 福利名称
     */
    private String benefitName;
    /**
     * 福利值
     */
    private Double benefitValue;


    public String getBenefitName() {
        return benefitName;
    }

    public void setBenefitName(String benefitName) {
        this.benefitName = benefitName;
    }

    public Double getBenefitValue() {
        return benefitValue;
    }

    public void setBenefitValue(Double benefitValue) {
        this.benefitValue = benefitValue;
    }

}

