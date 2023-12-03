package com.hang.domain.po;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2023-12-03 16:43:03
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User implements Serializable {
    //主键id
    @TableId
    private Integer id;

    //用户名
    private String username;
    //密码
    private String password;
    //状态: 1启用(默认) 0禁用
    private Integer status;
    //用户角色: 1:普通用户(默认) 0:管理员
    private Integer role;

}

