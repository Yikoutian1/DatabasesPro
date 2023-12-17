package com.hang.service;

import com.hang.domain.dto.PageInfoDto;
import com.hang.domain.po.SalaryInfo;
import com.hang.domain.vo.SalaryInfoVo;
import com.hang.result.Result;

/**
 * (SalaryInfo)表服务接口
 * @author Chen
 */
public interface SalaryInfoService {

    Result getSalaryInfo();

//    Result updateSalaryInfo(Integer id);
//
     void updateSalaryInfo(SalaryInfo salaryInfo );

    void deleteSalaryInfo(Integer id);

    void insertSalaryInfo(SalaryInfo salaryInfo);
}
