package com.hang.domain.po;


import java.io.Serializable;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Employee)表实体类
 *
 * @author Calyee
 * @since 2023-12-04 20:25:15
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("employee")
public class Employee implements Serializable{
    @TableId
    @ExcelProperty("员工编号")
    private Integer id;

    //员工姓名
    @ExcelProperty("员工姓名")
    private String name;

    //性别: 1男性(默认) 0女性
    @ExcelProperty("性别")
    private String sex;

    //所在部门
    @ExcelProperty("所在部门")
    private String dept;

    //工资级别
    @ExcelProperty("工资级别")
    private String salaryJb;

    //工资等级
    @ExcelProperty("工资等级")
    private String salaryDj;



}

