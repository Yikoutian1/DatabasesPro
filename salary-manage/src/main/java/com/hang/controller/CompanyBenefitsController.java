package com.hang.controller;



import com.hang.result.Result;
import com.hang.service.CompanyBenefitsService;
import com.hang.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Calyee
 * @since 2023-12-19 16:13:36
 */
@CrossOrigin
@RestController
@RequestMapping("/companyBenefits")
public class CompanyBenefitsController{
    @Autowired
    private CompanyBenefitsService companyBenefitsService;

    /**
     * 获取所有的对照信息
     * @return
     */
    @GetMapping("/getAllInfo")
    public Result getAllInfo(){
        return companyBenefitsService.getAllInfo();
    }
}

