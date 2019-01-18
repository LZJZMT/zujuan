package com.zujuan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zujuan.pojo.*;
import com.zujuan.service.ExamService;
import com.zujuan.service.ExamTypeService;
import com.zujuan.service.KnowledgeService;
import com.zujuan.utils.BeanUtil;
import com.zujuan.utils.GetResultBean;
import com.zujuan.utils.ResultViewMap;
import com.zujuan.vo.ExaminationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Controller
public class ExamController {

    @Autowired
    private ExamService es;

    @Autowired
    private ExamTypeService ets;
    @Autowired
    private KnowledgeService ks;

    @ResponseBody
    @RequestMapping("/add")
    public Map addExam(Examination examination, String optionA, String optionB,
                       String optionC, String optionD, Long knowIdChild) {

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
            if(examination.getEid() != null){
                ExaminationExample example = new ExaminationExample();
                example.createCriteria().andEidEqualTo(examination.getEid());
                es.updateByExample(examination, example);
            }else {
                es.add(examination);
            }

        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            e.printStackTrace();
        }
        return resultMap;


    }

    //搜索和获取所有知识点
    @ResponseBody
    @RequestMapping("/list")
    public PageBean list(Examination examination, Integer page, Integer limit) {

        if (StringUtils.isEmpty(examination.getQuestion())
                && StringUtils.isEmpty(examination.getDegree())
                && StringUtils.isEmpty(examination.getType())) {
            return es.list(null, page, limit);
        } else {
            ExaminationExample example = new ExaminationExample();
            ExaminationExample.Criteria criteria = example.createCriteria();
            if (!StringUtils.isEmpty(examination.getQuestion())){
                criteria.andQuestionLike("%" + examination.getQuestion() + "%");
               }
            if (!StringUtils.isEmpty(examination.getDegree())){
                criteria.andDegreeEqualTo(examination.getDegree());
            }
            if (!StringUtils.isEmpty(examination.getType())){
                criteria.andTypeEqualTo(examination.getType());
            }
            List list2 = es.selectByExample(example);
            List<ExaminationVO> list = BeanUtil.copyList(list2, ExaminationVO.class);
            Map typeViewMap = ResultViewMap.getTypeViewMap();
            Map degreeViewMap = ResultViewMap.getDegreeViewMap();
            for (ExaminationVO examVO : list){
                examVO.setZsdname(ks.selectByPrimary(examVO.getKnowId()).getZsdname());
                examVO.setTypeString((String)typeViewMap.get(examVO.getType()));
                examVO.setDegreeString((String)degreeViewMap.get(examVO.getDegree()));
            }

            long count = es.countByExample(example);
            return new PageBean(String.valueOf(count), list);


        }

    }


    @ResponseBody
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

    @ResponseBody
    //根据ID删除知识点
    @RequestMapping("/delById")
    public Map delById(Long id) {
        Map resultMap = GetResultBean.getResultMap();
        try {
            es.del(id);
            System.out.println(id + "已删除");
        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            resultMap.put("msg", "删除失败");
        }
        return resultMap;
    }

    //根据ID获得考试试题
    @ResponseBody
    @RequestMapping("/getById")
    public Map getById(Long eid) {
        Map resultMap = GetResultBean.getResultMap();
        try {
            Examination e = es.getById(eid);
            resultMap.put("data", e);
        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            resultMap.put("msg", "删除失败");
        }
        return resultMap;
    }

    @RequestMapping("/editExam")
    public String editExam(Long eid, ModelMap modelMap) {
        ExaminationVO exVo = BeanUtil.copy(es.getById(eid), ExaminationVO.class);
        exVo.setTypeString((String) ResultViewMap.getTypeViewMap().get(exVo.getType()));
        exVo.setDegreeString((String) ResultViewMap.getDegreeViewMap().get(exVo.getDegree()));
        modelMap.addAttribute("exVo", exVo);

        List<ExamType> examTypes = ets.listAll();
        String optionJson = exVo.getOptionJson();
        Map map = (Map) JSONArray.parse(optionJson);
        modelMap.addAttribute("option", map);
        modelMap.addAttribute("examTypes", examTypes);

        List<Knowledge> fatherSelect = ks.listParent();
        modelMap.addAttribute("father",fatherSelect);
        boolean flag = false;
        for (Knowledge knowledge : fatherSelect) {
            if (knowledge.getId().equals(exVo.getKnowId())){
                modelMap.addAttribute("fatherId",knowledge.getId());
                 flag = true;
                break;
            }
        }
        if (!flag){
            KnowledgeExample knowledgeExample = new KnowledgeExample();
            KnowledgeExample knowledgeExample2 = new KnowledgeExample();
            knowledgeExample2.createCriteria().andIdEqualTo(exVo.getKnowId());
            Knowledge knowledge = (Knowledge) ks.selectByExample(knowledgeExample2).get(0);
            modelMap.addAttribute("fatherId",knowledge.getParentid());

            knowledgeExample.createCriteria().andParentidEqualTo(knowledge.getParentid());
            List childSelect = ks.selectByExample(knowledgeExample);
            modelMap.addAttribute("child",childSelect);
        }


        return "editExam";
    }

    @RequestMapping("seeExam")
    public String seeExam(Long eid, ModelMap modelMap){
        ExaminationVO vo = BeanUtil.copy(es.getById(eid), ExaminationVO.class);
        //解析JSONString为Map
        String optionJson = vo.getOptionJson();
        Map map = (Map) JSONArray.parse(optionJson);
        modelMap.addAttribute("option", map);

        //转成VO类
        vo.setTypeString((String) ResultViewMap.getTypeViewMap().get(vo.getType()));
        vo.setDegreeString((String) ResultViewMap.getDegreeViewMap().get(vo.getDegree()));
        vo.setZsdname(ks.selectByPrimary(vo.getKnowId()).getZsdname());

        modelMap.addAttribute("vo", vo);

        return "seeExam";
    }


    //根据多个ID，试题条件获得试题
    @RequestMapping("/getExamForZuJuan")
    @ResponseBody
    public PageBean getExamForZuJuan(Long[] ids,Examination exam,Integer curPage,Integer limit){
        if (ids.length == 0){
            ids = null;
        }
        if ("".equals(exam.getQuestion())){
            exam.setQuestion(null);
        }
        return es.selectByConditionPage(ids,exam,curPage,limit);
    }


}
