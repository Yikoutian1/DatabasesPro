package com.hang.controller;


import com.hang.domain.dto.EmployeeDto;
import com.hang.domain.dto.PageInfoDto;
import com.hang.domain.po.Employee;
import com.hang.result.Result;
import com.hang.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
     * 新增用户
     * TODO 前端新增用户
     *
     * @param employeeDto Form
     * @return 200
     */
    @PostMapping("/saveEmployeeInfo")
    public Result saveEmployeeInfo(@RequestBody EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employee.setId(null); // 置id为空
        employeeService.save(employee);
        return Result.success();
    }

    /**
     * 更新
     *
     * @param employeeDto Form
     * @return Result
     */
    @PutMapping
    public Result updateEmployeeInfo(@RequestBody EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.updateById(employee);
        return Result.success();
    }

    /**
     * 根据id删除用户
     *
     * @param id 用户id
     * @return success 200
     */
    @DeleteMapping("/{id}")
    public Result delEmployee(@PathVariable("id") Integer id) {
        employeeService.removeById(id);
        return Result.success();
    }
}

