package com.zujuan.serviceImpl;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
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

@Component("myAuthenticationFailHander")
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Map<String,Object> map=new HashMap<>();
        map.put("code", "1");
        map.put("msg", "用户名或密码错误");
        String res = JSON.toJSONString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(res);

    }
}
