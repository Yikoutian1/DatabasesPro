package com.hang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hang.domain.po.Employee;
import com.hang.domain.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * (Employee)表数据库访问层
 *
 * @author Calyee
 * @since 2023-12-04 20:25:25
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    User getByUsername(@Param("username") String username);
}

