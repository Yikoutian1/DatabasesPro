package com.hang.controller;



import com.hang.domain.po.Experience;
import com.hang.domain.po.SalaryLevel;
import com.hang.result.Result;
import com.hang.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Experience)表控制层
 *
 * @author Calyee
 * @since 2023-12-19 15:05:29
 */
@CrossOrigin
@RestController
@RequestMapping("/experience")
public class ExperienceController{
    @Autowired
    private ExperienceService experienceService;

    /**
     * 获取所有的对照信息(工龄和奖金)
     * @return
     */
    @GetMapping("/getAllInfo")
    public Result getAllInfo(){
        return experienceService.getAllInfo();
    }


    @RequestMapping(value = "/updateSalaryExp", method = {RequestMethod.POST, RequestMethod.GET})
    public Result updateSalary(@RequestBody Experience experience) {
        experienceService.updateSalary(experience);
        return Result.success();
    }

    @RequestMapping(value = "/insertSalaryExp", method = {RequestMethod.POST, RequestMethod.GET})
    public Result insertSalaryExp(@RequestBody Experience experience) {
        experienceService.insertSalaryExp(experience);
        return Result.success();
    }
}

