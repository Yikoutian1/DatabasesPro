package com.hang.domain.vo;

import com.hang.domain.po.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenefitVo {
    private String name;
    private Double value;
}
