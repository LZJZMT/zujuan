package com.zujuan.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/9 14:11
 */
@Controller
public class MyErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/404.html";
    }

    @RequestMapping("/error")
    public String error(){
        return getErrorPath();
    }
}
