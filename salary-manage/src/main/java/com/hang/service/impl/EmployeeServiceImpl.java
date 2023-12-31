package com.hang.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hang.domain.dto.PageInfoDto;
import com.hang.domain.po.Employee;
import com.hang.domain.po.SalaryLevel;
import com.hang.domain.vo.EmployeeVo;
import com.hang.mapper.EmployeeMapper;
import com.hang.result.Result;
import com.hang.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Employee)表服务实现类
 *
 * @author Calyee
 * @since 2023-12-04 20:25:25
 */
@Service("employeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Override
    public Result getEmployeeInfo(PageInfoDto pageInfo) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        Page<Employee> page = new Page<>(pageInfo.getPageNum(), pageInfo.getPageSize());
        if ("desc".equalsIgnoreCase(pageInfo.getOrderBy())) {
            queryWrapper.orderByDesc(pageInfo.getSortBy());
        } else {
            queryWrapper.orderByAsc(pageInfo.getSortBy());
        }
        page(page, queryWrapper);
        List<Employee> records = page.getRecords();
        // 没有查询到数据
        if (records == null) {
            return Result.build(null, 201, "用户列表为空");
        }
        return Result.success(EmployeeVo.builder()
                .records(records)
                .total(page.getTotal())
                .build());
    }

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 分页查询员工信息
     *
     * @param pageInfo 分页参数
     * @return List
     */
    @Override
    public Result getEmployeeByM(PageInfoDto pageInfo, String name) {
        List<Employee> employees = employeeMapper.getEmployeeInfo(pageInfo,
                pageInfo.getMybatisPage(),
                name);
        int size = employees.size();
        if (0 == size) {
            return Result.build(null, 201, "用户列表为空");
        }
        return Result.success(EmployeeVo.builder()
                .records(employees)
                .total((long) size)
                .build());
    }
}

