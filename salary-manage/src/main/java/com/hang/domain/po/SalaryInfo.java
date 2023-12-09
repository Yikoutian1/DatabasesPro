package com.hang.domain.po;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (SalaryInfo)表实体类
 *
 * @author Calyee
 * @since 2023-12-05 19:27:38
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("salary_info")
public class SalaryInfo implements Serializable{
    @TableId
    private Integer empId;

    //员工姓名
    private String empName;
    //员工基础工资
    private Double baseSalary;
    //员工岗位工资
    private Double jobSalary;
    //员工工龄工资
    private Double expSalary;
    //公司福利
    private Double companyBenefits;
    //员工实得工资
    private Double netSalary;



}

