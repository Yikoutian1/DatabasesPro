package com.hang.enums;

import lombok.Data;

/**
 * @ClassName UserStatusEnums
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/12/03 003 17:21
 * @Version 1.0
 */
@Data
public class UserStatusEnums {
    /**
     * 用户已被禁用
     */
    public final static Integer FORBIDDEN_USER_STATUS = 0;
    /**
     * 用户状态正常
     */
    public final static Integer NORMAL_USER_STATUS = 1;
    /**
     * 管理员权限
     */
    public final static Integer ADMIN_USER_ROLE = 0;
    /**
     * 普通用户权限
     */
    public final static Integer NORMAL_USER_ROLE = 1;
}
