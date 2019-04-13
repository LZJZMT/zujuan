package com.zujuan.controller;

import com.zujuan.pojo.ExamBasketExample;
import com.zujuan.pojo.ExamPaper;
import com.zujuan.pojo.Examination;
import com.zujuan.pojo.PagerExamR;
import com.zujuan.service.ExamBasketService;
import com.zujuan.service.ExamPaperService;
import com.zujuan.service.ExamService;
import com.zujuan.service.PagerExamRService;
import com.zujuan.serviceImpl.ExamPaperData;
import com.zujuan.utils.GetCurrentUser;
import com.zujuan.utils.GetResultBean;
import com.zujuan.vo.PagerExamRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: lizijian
 * @Date： 2019/4/9 9:01
 */

@RequestMapping("/examPaper")
@Controller
public class ExamPaperController {

    @Autowired
    private ExamService examService;

    @Autowired
    private ExamPaperService examPaperService;

    @Autowired
    private PagerExamRService pagerExamRService;

    @Autowired
    private ExamBasketService examBasketService;

    @RequestMapping("/myExamPaper")
    public String myExamPaper(ModelMap modelMap) {
        List<ExamPaper> myExamPaperList = null;
        try {
            myExamPaperList = examPaperService.getMyExamPaper();
            for (ExamPaper examPaper : myExamPaperList) {
                Date time = examPaper.getCreateTime();
            }
            modelMap.addAttribute("user", GetCurrentUser.getCurrentUser());
        } catch (Exception e) {
            return "redirect:/views/user/login.html";
        }
        modelMap.addAttribute("examPaperList", myExamPaperList);
        return "examPaperList";
    }

    @ResponseBody
    @RequestMapping("/addExamPaperR")
    public Map saveExamScore(PagerExamRVO e) {
        Map resultMap = GetResultBean.getResultMap();
        ExamPaperData.list = e.getExamPaper();
        return null;
    }

    @ResponseBody
    @RequestMapping("/addExamPaper")
    public Map saveExamPaper(ExamPaper examPaper) throws Exception {
        Map resultMap = GetResultBean.getResultMap();
        examPaper.setAuthorId(GetCurrentUser.getCurrentUser().getId());
        examPaper.setCreateTime(new Date());
        List<PagerExamR> list = ExamPaperData.list;
        if (list == null || list.size() == 0) {
            return GetResultBean.getFailResultMap();
        }
        double degree = 0d;
        int totalScore = 0;
        for (PagerExamR pagerExamR : list) {
            Long eid = pagerExamR.getEid();
            Examination examServiceById = examService.getById(eid);
            degree += examServiceById.getDegree();
            if (pagerExamR.getScore() != null) {
                totalScore += pagerExamR.getScore();
            }

        }
        DecimalFormat df = new DecimalFormat("#.0");
        Double format = Double.valueOf(df.format(degree / list.size()));
        examPaper.setDegree(format);
        examPaper.setTotalScore(totalScore == 0 ? 100 : totalScore);
        String file_url = examPaperService.generateDocFromBasket(examPaper.getName());
        examPaper.setFileUrl(file_url);
        examPaperService.add(examPaper);

        for (PagerExamR pagerExamR : list) {
            pagerExamR.setId(null);
            pagerExamR.setPid(examPaper.getPid());
            pagerExamRService.add(pagerExamR);
        }

        //删除试题蓝的试题
        ExamBasketExample basketExample = new ExamBasketExample();
        basketExample.createCriteria().andUserIdEqualTo(GetCurrentUser.getCurrentUser().getId());
        examBasketService.delByExample(basketExample);

        return resultMap;
    }

}