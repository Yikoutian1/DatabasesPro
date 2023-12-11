package com.hang.controller;


import com.hang.domain.dto.EmployeeDto;
import com.hang.domain.dto.PageInfoDto;
import com.hang.domain.po.Employee;
import com.hang.result.Result;
import com.hang.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Employee)表控制层
 *
 * @author Calyee
 * @since 2023-12-04 20:25:15
 */
@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 通过分页获取员工信息
     *
     * @param pageInfo 页面信息
     * @return Result<List < Employee>>
     */

    @RequestMapping(value = "/getEmployeeInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public Result getEmployeeInfo(PageInfoDto pageInfo) {
        return employeeService.getEmployeeInfo(pageInfo);
    }

    @RequestMapping(value = "/useMyBatisMethodToGetEmployeeInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public Result testUseMyBatisMethodToGetEmployeeInfo(PageInfoDto pageInfo) {
        return employeeService.useMyBatisMethodToGetEmployeeInfo(pageInfo);
    }

    /**
     * 更新
     *
     * @param employeeDto Form
     * @return Result
     */
    @PutMapping
    public Result saveEmployeeInfo(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.save(employee);
        return Result.success();
    }
}

