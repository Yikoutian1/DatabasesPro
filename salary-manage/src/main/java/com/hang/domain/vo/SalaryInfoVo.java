package com.hang.domain.vo;

import com.hang.domain.po.Employee;
import com.hang.domain.po.SalaryInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalaryInfoVo {
    /**
     * 总数
     */
    private Long total;

    /**
     * 记录
     */
    private List<SalaryInfo> records;
}
