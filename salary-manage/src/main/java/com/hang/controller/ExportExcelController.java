package com.hang.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.hang.domain.po.Employee;
import com.hang.enums.UserStatusEnums;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @ClassName ExportExcelController
 * @Description 导入导出excel
 * @Author QiuLiHang
 * @DATE 2023/12/19 019 22:25
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/upload")
public class ExportExcelController {
    @PostMapping("/export/forEmployee")
    public void simpleWrite(@RequestBody List<Employee> employees,
                            HttpServletRequest request,
                            HttpServletResponse response) throws IOException {

        String origin = System.currentTimeMillis() + ".xlsx";
        String fileName = new String(origin.getBytes(), StandardCharsets.ISO_8859_1);
        response.setContentType("application/msexcel");
        response.setCharacterEncoding("utf8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName );

        List<Employee> data = data(employees);
        // EasyExcel.write(fileName, Employee.class).sheet("模板").doWrite(data);
        EasyExcel.write(response.getOutputStream(), Employee.class)
                .sheet("sheet")
                .doWrite(data);

    }

    private List<Employee> data(List<Employee> employees) {
        List<Employee> list = ListUtils.newArrayList();
        for (Employee employee : employees) {
            Employee e = new Employee();
            e.setId(employee.getId());
            e.setDept(employee.getDept());
            if (employee.getSex().equals(UserStatusEnums.MALE)) {
                e.setSex("男");
            } else {
                e.setSex("女");
            }
            e.setName(employee.getName());
            e.setSalaryDj(employee.getSalaryDj());
            e.setSalaryJb(employee.getSalaryJb());
            list.add(e);
        }
        return list;
    }
}
