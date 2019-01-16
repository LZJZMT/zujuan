package com.zujuan.service;

import com.zujuan.pojo.Examination;
import com.zujuan.pojo.ExaminationExample;
import com.zujuan.pojo.PageBean;

import java.util.List;

public interface ExamService {
    PageBean list(Examination examination, Integer page, Integer limit);

    void add(Examination examination);


    void del(Long id);

    void updateByExample(Examination examination, ExaminationExample example);

    List selectByExample(ExaminationExample example);

    long countByExample(ExaminationExample example);

    Examination getById(Long id);
}
