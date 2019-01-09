package com.zujuan.controller;

import com.zujuan.pojo.MailBean;
import com.zujuan.pojo.User;
import com.zujuan.service.UserService;
import com.zujuan.utils.GetCurrentUser;
import com.zujuan.utils.GetResultBean;
import com.zujuan.utils.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/8 17:38
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService us;
    @Autowired
    private SendMail sendMail;

    @RequestMapping("/changePwd")
    public Map changePwd(String oldPassword, String password) {
        HashMap map = new HashMap();
        map.put("code","0");
        map.put("msg","操作成功");
        try {
            if(oldPassword.equals(GetCurrentUser.getCurrentUser().getPassword())){
                us.changePwd(password);
            }else {
                throw new RuntimeException("原密码错误");
            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","0");
            map.put("msg",e.getMessage());
        }
        return map;

    }

    @RequestMapping("/sendEmail")
    public Map sendEmail(String email,String type){
        Map result = GetResultBean.getResultMap();
        try {
            if ("0".equals(type)){
                MailBean mailBean = new MailBean();
                mailBean.setAddress(email);
                String checkCode = Integer.toString((int) ((Math.random() * 9 + 1) * 100000));
                request.getSession().setAttribute("loginCheckCode",checkCode);
                mailBean.setContent("<h3>您的验证码为</h3><h2>"+checkCode+"</h2>");
                mailBean.setTitle("【离散数学组卷系统 验证码】");
                sendMail.sendSimpleMail(mailBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = GetResultBean.getFailResultMap();
        }
        return result;

    }

    @RequestMapping("/register")
    public Map register(User u,String vercode){
        Map resultMap = GetResultBean.getResultMap();

    }

}
