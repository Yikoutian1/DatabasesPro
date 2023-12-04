package com.hang.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordUtilsTest {
    @Test
    public void testPassword() {
        String originPassword = "123456";
        System.out.println("加密前的密码为: " + 123456);

        String encrypt = PasswordUtils.encrypt(originPassword);
        System.out.println("加密后的密码为: " + encrypt);

        boolean check = PasswordUtils.check(originPassword, encrypt);
        System.out.println("验证前后是否一致:  " + check);
    }
}