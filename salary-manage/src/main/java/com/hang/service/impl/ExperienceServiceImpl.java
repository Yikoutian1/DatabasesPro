package com.hang.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hang.domain.po.Experience;
import com.hang.mapper.ExperienceMapper;
import com.hang.mapper.SalaryLevelMapper;
import com.hang.result.Result;
import com.hang.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Experience)表服务实现类
 *
 * @author Calyee
 * @since 2023-12-19 15:05:33
 */
@Service("experienceService")
public class ExperienceServiceImpl extends ServiceImpl<ExperienceMapper, Experience> implements ExperienceService {

    @Autowired
    private ExperienceMapper experienceMapper;

    @Override
    public Result getAllInfo() {
        return Result.success(baseMapper.selectList(null));
    }

    @Override
    public void updateSalary(Experience experience) {
        experienceMapper.updateSalary(experience);
    }
}

