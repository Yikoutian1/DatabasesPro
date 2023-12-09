package com.hang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hang.domain.po.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * (Dept)表数据库访问层
 *
 * @author Calyee
 * @since 2023-12-05 21:05:56
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

    List<String> getDeptLevel();
}

