package com.hang.controller;


import com.hang.domain.po.SalaryLevel;
import com.hang.domain.vo.SalarySelectVo;
import com.hang.mapper.SalaryLevelMapper;
import com.hang.result.Result;
import com.hang.service.SalaryLevelService;
import com.hang.utils.BeanCopyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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
     * TODO 工资等级和级别对照表
     *
     * @return List<SalarySelectVo>
     */
    @GetMapping("/getSalaryLevel")
    public Result getSalaryLevel(String name) {
        Map<String,Object> salaryContract  = salaryLevelService.getSalaryContract(name);
        return Result.success(salaryContract);
    }
    /**
     * 仅仅获取不重复的部门名
     * @return
     */
    @GetMapping("/getSalaryOnlyLevel")
    public Result getSalaryOnlyLevel() {
        List<String> salaryContract  = salaryLevelService.getSalaryOnlyLevel();
        return Result.success(salaryContract);
    }
}

