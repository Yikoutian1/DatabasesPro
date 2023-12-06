package com.hang.controller;


import com.hang.mapper.SalaryLevelMapper;
import com.hang.result.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    private final SalaryLevelMapper salaryLevelMapper;

    @GetMapping("/getSalaryLevel")
    public Result getSalaryLevel() {
        return Result.success(salaryLevelMapper.getSalaryLevel());
    }
}

