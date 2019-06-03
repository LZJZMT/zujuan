package com.zujuan.controller;

import com.zujuan.pojo.*;
import com.zujuan.service.ExamService;
import com.zujuan.service.KnowledgeService;
import com.zujuan.utils.GetResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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

    @Autowired
    private ExamService es;

    @ResponseBody
    @RequestMapping("/getExamByZsdIds")
    public int[] getExamByZsdIds(String ids){
        int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        if (ids == null || "".equals(ids)){
            return nums;
        }
        String[] zsdIdsStr = ids.split(",");
        Long[] zsdIds = new Long[zsdIdsStr.length];
        for (int i = 0; i < zsdIdsStr.length; i++) {
            zsdIds[i] = Long.decode(zsdIdsStr[i]);
        }
        List<Long> zsdIdList = new ArrayList();

        for (Long zsdId : zsdIds) {
            zsdIdList.add(zsdId);
        }
        KnowledgeExample knowledgeExample = new KnowledgeExample();
        knowledgeExample.createCriteria().andParentidIn(zsdIdList);
        List<Knowledge> knowledgeList = ks.selectByExample(knowledgeExample);
        for (Knowledge knowledge : knowledgeList) {
            zsdIdList.add(knowledge.getId());
        }
        HashSet h = new HashSet(zsdIdList);
        zsdIdList.clear();
        zsdIdList.addAll(h);
        ExaminationExample examinationExample = new ExaminationExample();
        examinationExample.createCriteria().andKnowIdIn(zsdIdList);
        List<Examination> list = es.selectByExample(examinationExample);

        ArrayList<Integer> num = new ArrayList<>();

        for (Examination examination : list) {
            switch (examination.getType()){
                case 1:switch (examination.getDegree().intValue()){
                    case 1:nums[0]++;break;
                    case 2:nums[1]++;break;
                    case 3:nums[2]++;break;
                    case 4:nums[3]++;break;
                }break;
                case 2:switch (examination.getDegree().intValue()){
                    case 1:nums[4]++;break;
                    case 2:nums[5]++;break;
                    case 3:nums[6]++;break;
                    case 4:nums[7]++;break;
                }break;
                case 3:switch (examination.getDegree().intValue()){
                    case 1:nums[8]++;break;
                    case 2:nums[9]++;break;
                    case 3:nums[10]++;break;
                    case 4:nums[11]++;break;
                }break;
                case 4:switch (examination.getDegree().intValue()){
                    case 1:nums[12]++;break;
                    case 2:nums[13]++;break;
                    case 3:nums[14]++;break;
                    case 4:nums[15]++;break;
                }break;
            }
        }
        return nums;

    }

    //搜索和获取所有知识点
    @RequestMapping("/list")
    public PageBean list(Knowledge knowledge, Integer page, Integer limit){
        if (knowledge == null || StringUtils.isEmpty(knowledge.getZsdname())){
            return ks.list(null,page,limit);
        }else{
            KnowledgeExample example = new KnowledgeExample();
            example.createCriteria().andZsdnameLike("%"+knowledge.getZsdname()+"%");
            List list = ks.selectByExample(example);
            long count = ks.countByExample(example);
            return new PageBean(String.valueOf(count),list);
        }

    }

    //添加知识点
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
    //更新知识点
    @RequestMapping("/updateZsd")
    public Map updateZsd(Knowledge knowledge){
        Map resultMap = GetResultBean.getResultMap();
        try {
            KnowledgeExample example = new KnowledgeExample();
            example.createCriteria().andIdEqualTo(knowledge.getId());
            ks.updateByExample(knowledge,example);
            resultMap.put("msg","更新成功");
        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            resultMap.put("msg",e.getMessage());
        }
        return resultMap;
    }

    //批量删除知识点
    @RequestMapping("/batchDel")
    public Map batchDel(@RequestBody Knowledge[] knowledges){
        List<Knowledge> knowledgeList = Arrays.asList(knowledges);
        Map resultMap = GetResultBean.getResultMap();
        try {
            for(Knowledge k : knowledgeList){
                ks.del(k.getId());
            }

        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            resultMap.put("msg","删除失败");
        }
        return resultMap;
    }

    //根据ID删除知识点
    @RequestMapping("/delById")
    public Map delById(Long id){
        Map resultMap = GetResultBean.getResultMap();
        try {
            ks.del(id);
        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            resultMap.put("msg","删除失败");
        }
        return resultMap;
    }

    //获取所有父id为空得知识点， 即父知识点
    @RequestMapping("/getAllParentZsd")
    public List<Knowledge> getAllParentZsd(){
        return ks.listParent();
    }

    @RequestMapping("getZsdByParebtId")
    public  List<Knowledge> getByParentId(Long parentId){
        KnowledgeExample knowledgeExample = new KnowledgeExample();
        knowledgeExample.createCriteria().andParentidEqualTo(parentId);
        return ks.selectByExample(knowledgeExample);
    }

    @RequestMapping("zsdTree")
    public List getZsdTree() {
        return ks.getZsdTree();
    }
}
