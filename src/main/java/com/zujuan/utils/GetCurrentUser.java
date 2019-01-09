package com.zujuan.utils;

import com.zujuan.pojo.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/9 14:28
 */
public class GetCurrentUser {
    public static User getCurrentUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
