package com.zujuan.serviceImpl;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/8 22:33
 */

@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        Map<String,Object> map=new HashMap<>();
        map.put("code", "0");
        map.put("ok", true);
        map.put("msg", "登录成功");
        String res = JSON.toJSONString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(res);

    }
}

