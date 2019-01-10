package com.zujuan.service;

import com.zujuan.pojo.Knowledge;
import com.zujuan.pojo.PageBean;

public interface KnowledgeService {
    PageBean list(Knowledge knowledge, Integer page, Integer limit);

    void add(Knowledge knowledge);


    //查询是否存在相同得知识点名字
    boolean isCunzai(String zsdname);
}
