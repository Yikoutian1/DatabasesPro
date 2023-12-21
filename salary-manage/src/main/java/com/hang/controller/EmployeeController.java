package com.hang.controller;


import com.hang.domain.dto.EmployeeDto;
import com.hang.domain.dto.PageInfoDto;
import com.hang.domain.po.Employee;
import com.hang.mapper.EmployeeMapper;
import com.hang.mapper.SalaryInfoMapper;
import com.hang.result.Result;
import com.hang.service.EmployeeService;
import com.hang.service.SalaryInfoService;
import com.hang.service.SalaryLevelService;
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

    @PostMapping(value = "/getEmployeeInfo")
    public Result getEmployeeInfo(PageInfoDto pageInfo) {
        return employeeService.getEmployeeInfo(pageInfo);
    }

    /**
     * 同上
     *
     * @param pageInfo 页面信息
     * @return List < Employee>
     */
    @PostMapping(value = "/getEmployeeByM")
    public Result getEmployeeByM(PageInfoDto pageInfo,
                                 @RequestParam(value = "name", required = false) String name) {
        return employeeService.getEmployeeByM(pageInfo, name);
    }

    @Autowired
    private SalaryLevelService salaryLevelService;

    /**
     * 新增用户
     * 前端新增用户
     *
     * @param employeeDto Form
     * @return 200
     */
    @PostMapping("/saveEmployeeInfo")
    public Result saveEmployeeInfo(@RequestBody EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employee.setId(null); // 置id为空
        String salaryJb = employeeDto.getSalaryJb();
        String data = (String) salaryLevelService.getSalaryContract(salaryJb).getData();
        employee.setSalaryDj(data);
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
    @Autowired
    private EmployeeMapper employeeMapper;
    /**
     * 根据id删除用户
     *
     * @param id 用户id
     * @return success 200
     */
    @GetMapping("/del")
    @Transactional(rollbackFor = Exception.class)
    public Result delEmployee(@RequestParam("id") Integer id) {
        Employee employee = employeeService.getById(id);
        employeeMapper.deleteSI(employee.getName());
        employeeService.removeById(id);
        return Result.success();
    }
}

