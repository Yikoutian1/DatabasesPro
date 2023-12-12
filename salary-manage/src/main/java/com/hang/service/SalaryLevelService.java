package com.hang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hang.domain.po.SalaryLevel;
import com.hang.domain.vo.SalarySelectVo;
import com.hang.result.Result;

import java.util.List;
import java.util.Map;

public interface SalaryLevelService extends IService<SalaryLevel> {
    Result getSalaryContract(String name);

    List<String> getSalaryOnlyLevel();
}
