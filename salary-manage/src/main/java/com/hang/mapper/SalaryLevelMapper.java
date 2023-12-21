package com.hang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hang.domain.po.SalaryLevel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * (SalaryLevel)表数据库访问层
 *
 * @author Calyee
 * @since 2023-12-05 20:56:40
 */
@Mapper
public interface SalaryLevelMapper extends BaseMapper<SalaryLevel> {


    List<SalaryLevel> getSalaryContract();

    List<String> getSalaryOnlyLevel();

    void updateSalaryLevel(SalaryLevel salaryLevel);

    void insertSalaryLevel(SalaryLevel salaryLevel);
}

