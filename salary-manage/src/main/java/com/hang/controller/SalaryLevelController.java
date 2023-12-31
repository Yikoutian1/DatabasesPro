package com.hang.controller;


import com.hang.domain.po.Experience;
import com.hang.domain.po.SalaryInfo;
import com.hang.domain.po.SalaryLevel;
import com.hang.domain.vo.SalarySelectVo;
import com.hang.enums.ResultCodeEnum;
import com.hang.mapper.SalaryLevelMapper;
import com.hang.result.Result;
import com.hang.service.SalaryLevelService;
import com.hang.utils.BeanCopyUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (SalaryLevel)表控制层
 *
 * @author Calyee
 * @since 2023-12-05 20:56:39
 */
@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/salaryLevel")
public class SalaryLevelController {

    private final SalaryLevelService salaryLevelService;

    /**
     * 获取所有的对照信息(工资等级和级别)
     * @return
     */
    @GetMapping("/getAllInfoLe")
    public Result getAllInfo(){
        return salaryLevelService.getAllInfo();
    }

    /**
     * 工资等级和级别对照表
     *
     * @return List<SalarySelectVo>
     */
    @GetMapping("/getSalaryLevel")
    public Result getSalaryLevel(String name) {
        if (!StringUtils.hasText(name)) {
            return Result.build("", ResultCodeEnum.INFO_EMPTY);
        }
        return salaryLevelService.getSalaryContract(name);
    }

    /**
     * 仅仅获取不重复的部门名
     *
     * @return Salary list
     */
    @GetMapping("/getSalaryOnlyLevel")
    public Result getSalaryOnlyLevel() {
        List<String> salaryContract = salaryLevelService.getSalaryOnlyLevel();
        return Result.success(salaryContract);
    }

    /**
     * 修改工资金额
     * @param salaryLevel
     * @return
     */
    @RequestMapping(value = "/updateSalaryInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public Result updateSalary(@RequestBody SalaryLevel salaryLevel) {
        salaryLevelService.updateSalary(salaryLevel);
        return Result.success();
    }

    @RequestMapping(value = "/insertSalaryLevel", method = {RequestMethod.POST, RequestMethod.GET})
    public Result insertSalaryExp(@RequestBody SalaryLevel salaryLevel) {
        salaryLevelService.insertSalaryExp(salaryLevel);
        return Result.success();
    }

}

