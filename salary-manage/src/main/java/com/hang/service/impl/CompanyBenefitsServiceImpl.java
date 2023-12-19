package com.hang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hang.domain.po.CompanyBenefits;
import com.hang.domain.vo.BenefitVo;
import com.hang.mapper.CompanyBenefitsMapper;
import com.hang.result.Result;
import com.hang.service.CompanyBenefitsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Calyee
 * @since 2023-12-19 16:13:40
 */
@Service
public class CompanyBenefitsServiceImpl extends ServiceImpl<CompanyBenefitsMapper, CompanyBenefits> implements CompanyBenefitsService {

    @Override
    public Result getAllInfo() {
        List<CompanyBenefits> companyBenefits = baseMapper.selectList(null);
        List<BenefitVo> benefitVos = new ArrayList<>();
        for (CompanyBenefits benefit : companyBenefits) {
            BenefitVo benefitVo = new BenefitVo();
            benefitVo.setValue(benefit.getBenefitValue());
            benefitVo.setName(benefit.getBenefitName());
            benefitVos.add(benefitVo);
        }
        return Result.success(benefitVos);
    }
}

