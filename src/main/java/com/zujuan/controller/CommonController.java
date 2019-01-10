package com.zujuan.controller;

import com.zujuan.utils.GetCurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/10 14:21
 */
@Controller
public class CommonController {

    @RequestMapping("/views/index")
    public String home(ModelMap modelMap){
        modelMap.addAttribute("username", GetCurrentUser.getCurrentUser().getUsername());
        return "index";
    }
}
