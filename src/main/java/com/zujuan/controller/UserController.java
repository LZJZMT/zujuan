package com.zujuan.controller;

import com.zujuan.pojo.MailBean;
import com.zujuan.pojo.User;
import com.zujuan.service.UserService;
import com.zujuan.utils.GetCurrentUser;
import com.zujuan.utils.GetResultBean;
import com.zujuan.utils.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/8 17:38
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService us;
    @Autowired
    private SendMail sendMail;

    @RequestMapping("/changePwd")
    @ResponseBody
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
    @ResponseBody
    @RequestMapping("/sendEmail")
    public Map sendEmail(String email,String type){
        Map result = GetResultBean.getResultMap();
        try {
            if ("0".equals(type)){
                MailBean mailBean = new MailBean();
                mailBean.setAddress(email);
                String checkCode = Integer.toString((int) ((Math.random() * 9 + 1) * 100000));
                request.getSession().setAttribute("registerCheckCode",checkCode);
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
    @ResponseBody
    @RequestMapping("/register")
    public Map register(User u,String vercode){
        Map resultMap = GetResultBean.getResultMap();;
        if (StringUtils.isEmpty(vercode) || !vercode.equals(request.getSession().getAttribute("registerCheckCode"))){
            resultMap.put("code","1");
            resultMap.put("msg","邮箱验证码错误");
            return resultMap;
        }
        List byUsername = us.getByUsername(u.getUsername());
        if(byUsername != null && byUsername.size() > 0){
            resultMap.put("code","1");
            resultMap.put("msg","用户名已存在");
            return resultMap;
        }else{
            Date date = new Date();
            u.setRegistertime(date);
            u.setType(2);//教师用户 Type为2
            us.insertUser(u);
            resultMap = GetResultBean.getResultMap();
            resultMap.put("msg","注册成功");
            request.getSession().setAttribute("registerCheckCode",null);
        }
        return resultMap;
    }

    @RequestMapping("/info")
    public String getInfo(ModelMap map){

        User user = GetCurrentUser.getCurrentUser();
        map.addAttribute("user",user);
        System.out.println(user);
        return "set/user/info";
    }

}
