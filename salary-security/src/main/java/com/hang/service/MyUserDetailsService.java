package com.hang.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @ClassName UserDetailsService
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/12/02 002 21:24
 * @Version 1.0
 */

public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据名字查询UserDetails

        return null;
    }
}
