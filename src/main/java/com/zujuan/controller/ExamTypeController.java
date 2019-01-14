package com.zujuan.controller;

import com.zujuan.pojo.ExamType;
import com.zujuan.service.ExamTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/14 16:48
 */

@RequestMapping("examType")
@Controller
public class ExamTypeController {

    @Autowired
    private ExamTypeService examTypeService;

    @ResponseBody
    @RequestMapping("/listAll")
    public List<ExamType> list(){
        return examTypeService.listAll();
    }
}
