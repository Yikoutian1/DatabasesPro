package com.hang.controller;


import com.hang.result.Result;
import com.hang.service.SalaryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/salaryInfo")
public class SalaryInfoController {
    @Autowired
    private SalaryInfoService salaryInfoService;

    @RequestMapping(value = "/getSalaryInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public Result getSalaryInfo() {
        return salaryInfoService.getSalaryInfo();
    }

}
