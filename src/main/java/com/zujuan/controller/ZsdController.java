package com.zujuan.controller;

import com.zujuan.pojo.Knowledge;
import com.zujuan.pojo.PageBean;
import com.zujuan.service.KnowledgeService;
import com.zujuan.utils.GetResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/10 15:34
 */
@RequestMapping("/zsd")
@RestController
public class ZsdController {

    @Autowired
    private KnowledgeService ks;
    @RequestMapping("/list")
    public PageBean list(Knowledge knowledge, Integer page, Integer limit){
        if (knowledge == null || StringUtils.isEmpty(knowledge.getZsdname())){
            return ks.list(null,page,limit);
        }
        return null;

    }
    @RequestMapping("/add")
    public Map list(Knowledge knowledge){
        Map resultMap = GetResultBean.getResultMap();
        try {
            if(ks.isCunzai(knowledge.getZsdname())){
                throw new RuntimeException("知识点已存在");
            }
            ks.add(knowledge);
        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            resultMap.put("msg",e.getMessage());
        }
        return resultMap;
    }
}
