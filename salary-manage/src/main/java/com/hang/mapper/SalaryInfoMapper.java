package com.hang.mapper;

import com.hang.domain.po.SalaryInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (SalaryInfo)表数据库访问层
 *
 * @author chen
 */
@Mapper
public interface SalaryInfoMapper {

    List<SalaryInfo> getSalaryInfo();

}
