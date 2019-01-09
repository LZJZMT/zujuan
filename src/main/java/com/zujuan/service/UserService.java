package com.zujuan.service;

import com.zujuan.pojo.User;

import java.util.List;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/9 14:24
 */
public interface UserService {
    void changePwd(String password);

    void insertUser(User u);

    List getByUsername(String username);
}
