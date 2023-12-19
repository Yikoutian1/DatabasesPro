package com.hang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hang.domain.po.CompanyBenefits;
import com.hang.result.Result;


/**
 * @author Calyee
 * @since 2023-12-19 16:13:40
 */
public interface CompanyBenefitsService extends IService<CompanyBenefits> {

    Result getAllInfo();
}

