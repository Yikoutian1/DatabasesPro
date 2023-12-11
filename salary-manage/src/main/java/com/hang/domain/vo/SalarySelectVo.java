package com.hang.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName DeptChoiseVo
 * @Description 关于工资各级别及其薪资对照表
 * @Author QiuLiHang
 * @DATE 2023/12/05 005 21:22
 * @Version 1.0
 */
@Data
public class SalarySelectVo {

    //工资级别
    private String salGrade;
    //工资金额
    private String salAmount;
    //工资级别对照工作名
    private String salJobName;
}
