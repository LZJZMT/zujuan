package com.zujuan.controller;

import com.zujuan.mapper.ScoreMapper;
import com.zujuan.pojo.*;
import com.zujuan.service.ExamPaperService;
import com.zujuan.utils.BeanUtil;
import com.zujuan.utils.GetResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/5/11 12:08
 */
@ResponseBody
@RequestMapping("/score")
@Controller
public class ScoreController {

    @Autowired
    private ScoreMapper sm;
    @Autowired
    private ExamPaperService examPaperService;
    //搜索和获取所有知识点

    @RequestMapping("/list")
    public PageBean list(Score score, Integer page, Integer limit){
        PageBean pageBean = new PageBean();
        List list;
        if (score == null || (StringUtils.isEmpty(score.getName())
                &&score.getXuehao()==null&&score.getPid()==null)) {
            list = sm.list((page - 1) * limit, limit);
            pageBean.setCount(sm.countByExample(null) + "");
            pageBean.setMsg("ok");
            pageBean.setCode("0");
        }else{
            ScoreExample example = new ScoreExample();
            ScoreExample.Criteria criteria = example.createCriteria();
            if (score.getXuehao() != null){
                criteria.andXuehaoEqualTo(score.getXuehao());
            }
            if (!StringUtils.isEmpty(score.getName())){
                criteria.andNameLike("%"+score.getName()+"%");
            }
            if (score.getPid()!=null){
                criteria.andPidEqualTo(score.getPid());
            }

            list = sm.selectByExample(example);
            pageBean.setCount(String.valueOf(sm.countByExample(example)));
        }

        List<ScoreVO> scoreVOS = BeanUtil.copyList(list, ScoreVO.class);
        for (ScoreVO scoreVO : scoreVOS) {
            ExamPaperExample examPaperExample = new ExamPaperExample();
            examPaperExample.createCriteria().andPidEqualTo(scoreVO.getPid());
            List<ExamPaper> list1 = examPaperService.selectByExample(examPaperExample);
            if (list1!= null && list1.size()>0){
                scoreVO.setExamName(list1.get(0).getName());
            }

        }
        pageBean.setData(scoreVOS);
        return pageBean;

    }

    //根据ID删除知识点
    @RequestMapping("/delById")
    public Map delById(Long id){
        Map resultMap = GetResultBean.getResultMap();
        try {
            sm.deleteByPrimaryKey(id);
        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            resultMap.put("msg","删除失败");
        }
        return resultMap;
    }

    //更新知识点
    @RequestMapping("/updateScore")
    public Map updateZsd(Score knowledge){
        Map resultMap = GetResultBean.getResultMap();
        try {
            ScoreExample example = new ScoreExample();
            example.createCriteria().andIdEqualTo(knowledge.getId());
            sm.updateByExampleSelective(knowledge,example);
            resultMap.put("msg","更新成功");
        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            resultMap.put("msg",e.getMessage());
        }
        return resultMap;
    }

    //批量删除知识点
    @RequestMapping("/batchDel")
    public Map batchDel(@RequestBody Score[] knowledges){
        List<Score> knowledgeList = Arrays.asList(knowledges);
        Map resultMap = GetResultBean.getResultMap();
        try {
            for(Score k : knowledgeList){
                sm.deleteByPrimaryKey(k.getId());
            }

        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            resultMap.put("msg","删除失败");
        }
        return resultMap;
    }

    @RequestMapping("/add")
    public Map add(Score score){
        System.out.println(score);
        try {
            sm.insert(score);
        } catch (Exception e) {
            e.printStackTrace();
            return GetResultBean.getFailResultMap();
        }
        return GetResultBean.getResultMap();
    }
}
