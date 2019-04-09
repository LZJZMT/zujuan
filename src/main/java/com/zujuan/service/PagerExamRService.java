package com.zujuan.service;

import com.zujuan.pojo.PagerExamR;
import com.zujuan.pojo.PagerExamRExample;

import java.util.List;

public interface PagerExamRService {
    void add(PagerExamR pagerExamR);

    void del(Long id);

    void updateByExample(PagerExamR pagerExamR, PagerExamRExample example);

    List selectByExample(PagerExamRExample example);

    long countByExample(PagerExamRExample example);

    PagerExamR getById(Long id);

    void delByExample(PagerExamRExample pagerExamRExample);
}
