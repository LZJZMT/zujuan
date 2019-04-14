package com.zujuan.service;

import com.zujuan.pojo.Examination;
import com.zujuan.pojo.ExaminationExample;
import com.zujuan.pojo.PageBean;
import com.zujuan.vo.ExaminationVO;

import java.util.List;

public interface ExamService {
    PageBean list(Examination examination, Integer page, Integer limit);

    void add(Examination examination);


    void del(Long id);

    void updateByExample(Examination examination, ExaminationExample example);

    List selectByExample(ExaminationExample example);

    long countByExample(ExaminationExample example);

    Examination getById(Long id);

    PageBean selectByConditionPage(Long[] ids, Examination exam, Integer curPage, Integer limit) throws Exception;

    List<ExaminationVO> convert2VOlist(List<Examination> examinations);

    List selectByExampleLimit(int i, double v, Integer integer);
}
