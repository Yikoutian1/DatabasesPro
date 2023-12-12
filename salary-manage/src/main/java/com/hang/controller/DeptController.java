package com.hang.controller;


import com.hang.mapper.DeptMapper;
import com.hang.result.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Dept)表控制层
 *
 * @author Calyee
 * @since 2023-12-05 21:05:56
 */
@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/dept")
public class DeptController {

    private final DeptMapper deptMapper;

    @GetMapping("/getDeptNameList")
    public Result getDeptNameList() {
        /**
         * 获取部门名称
         */
        return Result.success(deptMapper.getDeptName());
    }
}

