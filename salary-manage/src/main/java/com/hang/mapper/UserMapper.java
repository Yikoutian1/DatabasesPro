package com.hang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.hang.domain.po.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * (User)表数据库访问层
 *
 * @author Calyee
 * @since 2023-12-03 16:45:17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

