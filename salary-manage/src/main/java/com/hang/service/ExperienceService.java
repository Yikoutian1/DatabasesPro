package com.hang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hang.domain.po.Experience;
import com.hang.result.Result;


/**
 * (Experience)表服务接口
 *
 * @author Calyee
 * @since 2023-12-19 15:05:33
 */
public interface ExperienceService extends IService<Experience> {

    Result getAllInfo();

    void updateSalary(Experience experience);

    void insertSalaryExp(Experience experience);
}

