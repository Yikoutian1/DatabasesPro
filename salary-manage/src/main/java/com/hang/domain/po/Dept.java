package com.hang.domain.po;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Dept)表实体类
 *
 * @author Calyee
 * @since 2023-12-05 19:26:57
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("dept")
public class Dept implements Serializable{
    //部门名称
    private String deptName;

    //工作岗位名称
    private String jobTitle;
    //工作岗位工资
    private Double jobSalary;



}

