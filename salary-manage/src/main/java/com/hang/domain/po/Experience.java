package com.hang.domain.po;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Experience)表实体类
 *
 * @author Calyee
 * @since 2023-12-05 19:27:32
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("experience")
public class Experience implements Serializable{
    //工龄
    private Integer exp;

    //工资金额
    private Double salAmount;



}

