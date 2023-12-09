package com.hang.domain.po;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (CompanyBenfitits)表实体类
 *
 * @author Calyee
 * @since 2023-12-05 19:26:38
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("company_benfitits")
public class CompanyBenfitits implements Serializable{
    //福利名称
    private String benefitName;

    //福利值
    private Double benefitValue;



}

