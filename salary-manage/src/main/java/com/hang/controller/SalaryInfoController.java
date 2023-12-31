package com.hang.controller;



import com.hang.domain.dto.PageInfoDto;
import com.hang.domain.po.Employee;
import com.hang.domain.po.SalaryInfo;
import com.hang.domain.vo.SalaryInfoVo;
import com.hang.mapper.EmployeeMapper;
import com.hang.result.Result;
import com.hang.service.EmployeeService;
import com.hang.service.SalaryInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Employee)表控制层
 *
 * @author CH-EN-X
 */
@CrossOrigin
@RestController
@RequestMapping("/salaryInfo")
public class SalaryInfoController {
    @Autowired
    private SalaryInfoService salaryInfoService;

    /**
     * 获取全部员工的薪资信息
     * @return
     */
    @RequestMapping(value = "/getSalaryInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public Result getSalaryInfo() {
        return salaryInfoService.getSalaryInfo();
    }

    /**
     * 修改员工薪资信息
     * @param salaryInfo
     * @return
     */
    @RequestMapping(value = "/updateSalaryInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public Result updateSalaryInfo(@RequestBody SalaryInfo salaryInfo) {
        salaryInfoService.updateSalaryInfo(salaryInfo);
        return Result.success();
    }
    @Autowired
    private EmployeeMapper employeeMapper;
    /**
     * 新增员工薪资信息
     * @param salaryInfo
     * @return
     */
    @RequestMapping(value = "/insertSalaryInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public Result insertSalaryInfo(@RequestBody SalaryInfo salaryInfo) {
        Integer empId = employeeMapper.getEmpId(salaryInfo.getEmpName());
        // 如果没有这个人
        if(null == empId){
            return Result.fail();
        }
        salaryInfo.setEmpId(empId);
        salaryInfoService.insertSalaryInfo(salaryInfo);
        return Result.success();
    }

    /**
     * 删除员工薪资信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteSalaryInfo/{id}", method = {RequestMethod.POST, RequestMethod.GET,RequestMethod.DELETE})
    public Result deleteSalaryInfoById(@PathVariable("id") Integer id) {
        salaryInfoService.deleteSalaryInfo(id);
        return Result.success();
    }

    /**
     * 查询
     * @param param
     * @return
     */
    @RequestMapping(value = "/selectSalaryInfo/{param}", method = {RequestMethod.POST, RequestMethod.GET,RequestMethod.DELETE})
    public Result selectByParam(@PathVariable("param") String param) {
        return salaryInfoService.selectSalaryInfo(param);
    }



}
