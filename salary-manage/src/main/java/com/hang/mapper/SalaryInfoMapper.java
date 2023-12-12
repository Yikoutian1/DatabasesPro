package com.hang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hang.domain.dto.PageInfoDto;
import com.hang.domain.po.SalaryInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SalaryInfo)表数据库访问层
 *
 * @author chen
 */
@Mapper
public interface SalaryInfoMapper extends BaseMapper<SalaryInfo> {

    List<SalaryInfo> getSalaryInfo();
}
