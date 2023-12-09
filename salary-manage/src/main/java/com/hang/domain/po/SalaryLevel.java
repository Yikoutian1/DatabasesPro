package com.hang.domain.po;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (SalaryLevel)表实体类
 *
 * @author Calyee
 * @since 2023-12-09 22:44:53
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("salary_level")
public class SalaryLevel implements Serializable{

    //工资级别
    private String salGrade;
    //工资金额
    private String salAmount;
    //工资级别对照工作名
    private String salJobName;



}

