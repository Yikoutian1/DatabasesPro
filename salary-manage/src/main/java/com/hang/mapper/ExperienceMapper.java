package com.hang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hang.domain.po.Experience;
import org.apache.ibatis.annotations.Mapper;


/**
 * (Experience)表数据库访问层
 *
 * @author Calyee
 * @since 2023-12-19 15:05:33
 */
@Mapper
public interface ExperienceMapper extends BaseMapper<Experience> {

}

