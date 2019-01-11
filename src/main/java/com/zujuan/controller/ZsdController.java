package com.zujuan.controller;

import com.zujuan.pojo.Knowledge;
import com.zujuan.pojo.KnowledgeExample;
import com.zujuan.pojo.PageBean;
import com.zujuan.service.KnowledgeService;
import com.zujuan.utils.GetResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
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
}
