package com.hang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hang.domain.po.SalaryLevel;
import com.hang.domain.vo.SalarySelectVo;
import com.hang.mapper.SalaryLevelMapper;
import com.hang.service.SalaryLevelService;
import com.hang.utils.BeanCopyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName SalaryLevelServiceImpl
 * @Description 工资等级对照服务实现类
 * @Author QiuLiHang
 * @DATE 2023/12/10 010 20:28
 * @Version 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SalaryLevelServiceImpl extends ServiceImpl<SalaryLevelMapper, SalaryLevel> implements SalaryLevelService {

    private final SalaryLevelMapper salaryLevelMapper;

    @Override
    public Map<String, Object> getSalaryContract(String name) {
        Map<String, Object> res = new HashMap<>();
        // 如果没有则判空
        if (!StringUtils.hasText(name) || name == null) {
            return res;
        }
        List<SalaryLevel> salaryContract = salaryLevelMapper.getSalaryContract();
        for (SalaryLevel level : salaryContract) {
            if (level.getSalJobName().contains(name)) {
                res.put(name, level.getSalGrade());
            }
        }
        return res;
    }

    @Override
    public List<String> getSalaryOnlyLevel() {
        List<String> collect = salaryLevelMapper.getSalaryContract().stream()
                .map(SalaryLevel::getSalJobName)
                .collect(Collectors.toList());
        // 新结果集
        List<String> newRes = new ArrayList<>();
        // 切割
        collect.forEach(i -> {
            String[] oneRes = i.split(",");
            newRes.addAll(Arrays.asList(oneRes));
        });
        // 合并 返回
        return newRes;
    }
}
