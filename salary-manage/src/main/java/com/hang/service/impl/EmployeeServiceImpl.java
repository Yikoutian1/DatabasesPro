package com.hang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hang.domain.po.Employee;
import com.hang.mapper.EmployeeMapper;
import com.hang.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * (Employee)表服务实现类
 *
 * @author Calyee
 * @since 2023-12-04 20:25:25
 */
@Service("employeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}

