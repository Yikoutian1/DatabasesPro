package com.hang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hang.domain.dto.PageInfoDto;
import com.hang.domain.po.Employee;
import com.hang.domain.po.SalaryInfo;
import com.hang.domain.vo.EmployeeVo;
import com.hang.domain.vo.SalaryInfoVo;
import com.hang.mapper.EmployeeMapper;
import com.hang.mapper.SalaryInfoMapper;
import com.hang.result.Result;
import com.hang.service.SalaryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("salaryInfoService")
public class SalaryInfoServiceImpl extends ServiceImpl<SalaryInfoMapper, SalaryInfo> implements SalaryInfoService {

    @Autowired
    private SalaryInfoMapper salaryInfoMapper;

    @Override
    public Result getSalaryInfo() {
        QueryWrapper<SalaryInfo> queryWrapper = new QueryWrapper<>();
        List<SalaryInfo> records = salaryInfoMapper.getSalaryInfo();
        // 没有查询到数据
        if (records == null) {
            return Result.build(null, 201, "用户列表为空");
        }
        return Result
                .success(SalaryInfoVo.builder()
                        .records(records)
                        .build());
    }


}
