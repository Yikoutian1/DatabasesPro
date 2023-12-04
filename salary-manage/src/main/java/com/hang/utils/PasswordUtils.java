package com.hang.utils;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @ClassName PasswordUtils
 * @Description 密码加密
 * @Author QiuLiHang
 * @DATE 2023/12/04 004 18:50
 * @Version 1.0
 */

public class PasswordUtils {
    /**
     * 1.加盐并生成最终的密码
     *
     * @param password 明文的密码
     * @return 最终生成的密码
     */
    public static String encrypt(String password) {
        //a.产生盐值
        //UUID.randomUUID()会生成32位数字+4位-，是随机的唯一的，将4位-去掉就得到32位数字的盐值
        String salt = UUID.randomUUID().toString().replace("-", "");
        //生成加盐后的密码(需要使用MD5)
        String saltPassword = DigestUtils.md5DigestAsHex((salt + password).getBytes());
        //生成最终的密码格式
        String finalPassword = salt + "$" + saltPassword;
        return finalPassword;
    }

    /**
     * 2.加盐并生成最终密码格式（方法一的重载），区别于上面的方法：这个方法是用来解密的，给定了盐值，生成一个最终密码，
     * 后面要和正确的最终密码进行比对
     *
     * @param password 需要验证的明文密码
     * @param salt
     * @return
     */
    public static String encrypt(String password, String salt) {
        //1.生成一个加密后的密码
        String saltPassword = DigestUtils.md5DigestAsHex((salt + password).getBytes());
        //2.生成最终的密码（待验证）
        String finalPassword = salt + "$" + saltPassword;
        return finalPassword;
    }

    /**
     * 3.验证密码
     *
     * @param inputPassword 登录用户输入的明文密码
     * @param finalPassword 数据库中实际的最终密码格式
     * @return
     */
    public static boolean check(String inputPassword, String finalPassword) {
        //首先判断这两个参数到底有没有值,数据库中的最终密码是不是65位
        if (StringUtils.hasLength(inputPassword)
                && StringUtils.hasLength(finalPassword)
                && finalPassword.length() == 65) {
            //a.首先从最终的密码中得到盐值
            //使用$将finalPassword划分成两个部分，前面的32位的部分就是盐值
            //注意：这里的$是被认为是一个通配符，所以要转义一下
            String salt = finalPassword.split("\\$")[0];
            //b.使用之前加密的方法，生成最终的密码格式（待验证）
            String checkPassword = encrypt(inputPassword, salt);
            if (checkPassword.equals(finalPassword)) {
                return true;
            }
        }
        return false;
    }

}
