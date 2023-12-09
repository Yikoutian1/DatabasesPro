package com.hang.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hang.domain.dto.PageInfoDto;
import com.hang.domain.po.Employee;
import com.hang.result.Result;

/**
 * (Employee)表服务接口
 *
 * @author Calyee
 * @since 2023-12-04 20:25:25
 */
public interface EmployeeService extends IService<Employee> {

    Result getEmployeeInfo(PageInfoDto pageInfo);

    Result useMyBatisMethodToGetEmployeeInfo(PageInfoDto pageInfo);
}

