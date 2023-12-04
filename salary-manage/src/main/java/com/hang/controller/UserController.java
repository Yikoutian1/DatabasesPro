package com.hang.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hang.domain.po.User;
import com.hang.enums.UserStatusEnums;
import com.hang.result.Result;
import com.hang.service.UserService;
import com.hang.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    public Result login(@RequestBody User user, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        // (1)认证
        User one = userService.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, user.getUsername()));
        // (2) User one = userMapper.getByUsername(user.getUsername())
        // 用户不存在
        if (Objects.isNull(one)) {
            return Result.fail("用户不存在");
        }
        boolean check = PasswordUtils.check(user.getPassword(), one.getPassword());
        // 用户名或密码错误
        if (!check) {
            return Result.fail("用户名或密码错误");
        }
        user.setPassword("");
        // 认证成功
        session.setAttribute("info", user); // 需Session共享(不作考虑)
        String token = Objects.equals(user.getRole(), UserStatusEnums.ADMIN_USER_ROLE) ? "admin" : "user";
        map.put("token", token);
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
