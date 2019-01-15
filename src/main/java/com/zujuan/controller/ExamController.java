package com.zujuan.controller;

import com.alibaba.fastjson.JSON;
import com.zujuan.pojo.Examination;
import com.zujuan.pojo.ExaminationExample;
import com.zujuan.pojo.PageBean;
import com.zujuan.service.ExamService;
import com.zujuan.utils.GetResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/15 12:39
 */

@RequestMapping("/exam")
@RestController
public class ExamController {

    @Autowired
    private ExamService es;

    @RequestMapping("/add")
    public Map addExam(Examination examination, String optionA, String optionB,
                       String optionC, String optionD, Long knowIdChild) {
        System.out.println(examination);
        Map resultMap = GetResultBean.getResultMap();
        /*如果是选择题 添加到Map中 转JSON串加入到数据库*/
        try {
            if (examination.getType() == 1) {
                HashMap optionMap = new HashMap();
                if (!StringUtils.isEmpty(optionA)) {
                    optionMap.put("A", optionA);
                }
                if (!StringUtils.isEmpty(optionB)) {
                    optionMap.put("B", optionB);
                }
                if (!StringUtils.isEmpty(optionC)) {
                    optionMap.put("C", optionC);
                }
                if (!StringUtils.isEmpty(optionD)) {
                    optionMap.put("D", optionD);
                }
                String option = JSON.toJSONString(optionMap);
                examination.setOptionJson(option);
            }
            //如果选择了子知识点，设置题目关联子知识点
            if (knowIdChild != null) {
                examination.setKnowId(knowIdChild);
            }

            es.add(examination);
        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            e.printStackTrace();
        }
        return resultMap;


    }

    //搜索和获取所有知识点
    @RequestMapping("/list")
    public PageBean list(Examination examination, Integer page, Integer limit) {
        System.out.println(examination);
        if (examination == null || StringUtils.isEmpty(examination.getQuestion())
                || StringUtils.isEmpty(examination.getDegree())
                || StringUtils.isEmpty(examination.getType())) {
            return es.list(null, page, limit);
        } else {
            ExaminationExample example = new ExaminationExample();
            example.createCriteria().andQuestionEqualTo("%" + examination.getQuestion() + "%")
            .andDegreeEqualTo(examination.getDegree()).andTypeEqualTo(examination.getType());
            List list = es.selectByExample(example);
            long count = es.countByExample(example);
            return new PageBean(String.valueOf(count), list);
        }

    }


    //更新知识点
    @RequestMapping("/updateZsd")
    public Map updateZsd(Examination examination) {
        Map resultMap = GetResultBean.getResultMap();
        try {
            ExaminationExample example = new ExaminationExample();
            //example.createCriteria().andId(examination.getId());
            es.updateByExample(examination, example);
            resultMap.put("msg", "更新成功");
        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    //批量删除知识点
    @RequestMapping("/batchDel")
    public Map batchDel(@RequestBody Examination[] examinations) {
        List<Examination> examinationList = Arrays.asList(examinations);
        Map resultMap = GetResultBean.getResultMap();
        try {
            for (Examination k : examinationList) {
                es.del(k.getEid());
            }

        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            resultMap.put("msg", "删除失败");
        }
        return resultMap;
    }

    //根据ID删除知识点
    @RequestMapping("/delById")
    public Map delById(Long id) {
        Map resultMap = GetResultBean.getResultMap();
        try {
            es.del(id);
            System.out.println(id+"已删除");
        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            resultMap.put("msg", "删除失败");
        }
        return resultMap;
    }


}
