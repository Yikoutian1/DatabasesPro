package com.hang.domain.vo;

import com.hang.domain.po.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName EmployeeVo
 * @Description 员工Vo
 * @Author QiuLiHang
 * @DATE 2023/12/04 004 20:38
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeVo {
    /**
     * 总数
     */
    private Long total;
    /**
     * 记录
     */
    private List<Employee> records;
}
