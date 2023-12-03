package com.hang.controller;


import com.hang.domain.po.User;
import com.hang.result.Result;
import com.hang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AdminController
 * @Description TODO
 * @Author Calyee
 * @DATE 2023/12/01 001 22:41
 * @Version 1.0
 */

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 后台登录
     *
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        Map<String,Object> map = new HashMap<>();
        // TODO 认证

        // 认证成功
        map.put("token", "admin");
        // 返回权限
        return Result.ok(map);
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("/info")
    public Result info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles", "[admin]");
        map.put("name", "admin");
        map.put("avatar", "https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
        return Result.ok(map);
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    public Result logout() {
        return Result.ok();
    }
}
