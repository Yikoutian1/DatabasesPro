package com.hang.controller;


import com.hang.domain.vo.DeptSelectVo;
import com.hang.mapper.DeptMapper;
import com.hang.result.Result;
import com.hang.utils.BeanCopyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping("/getDeptList")
    public Result getDeptList() {
        /**
         * 获取例如董事长类职称
         */
        return Result.success();
    }
}

