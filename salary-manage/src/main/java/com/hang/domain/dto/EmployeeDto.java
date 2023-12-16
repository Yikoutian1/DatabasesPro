package com.hang.domain.dto;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Employee) DTO
 *
 * @author Calyee
 * @since 2023-12-04 20:25:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Integer id;
    //员工姓名
    private String name;
    //性别: 1男性(默认) 0女性
    private String sex;
    //所在部门
    private String dept;
    //工资级别
    private String salaryJb;
    //工资等级
    private String salaryDj;

}

