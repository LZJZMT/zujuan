package com.zujuan.service;

import com.zujuan.pojo.Knowledge;
import com.zujuan.pojo.KnowledgeExample;
import com.zujuan.pojo.PageBean;

import java.util.List;

public interface KnowledgeService {
    PageBean list(Knowledge knowledge, Integer page, Integer limit);

    void add(Knowledge knowledge);
    void getById(Long kid);

    //查询是否存在相同得知识点名字
    boolean isCunzai(String zsdname);

    void del(Long id);

    List<Knowledge> listParent();

    void updateByExample(Knowledge knowledge, KnowledgeExample example);

    List selectByExample(KnowledgeExample example);

    long countByExample(KnowledgeExample example);

    Knowledge selectByPrimary(Long id);

    List getZsdTree();
}
