package com.zujuan.service;

import com.zujuan.pojo.*;

import java.util.List;

/**
 * @Description:
 * @Author: lizijian
 * @Date： 2019/4/9 9:09
 */
public interface ExamPaperService {
    void add(ExamPaper examPaper);

    void del(Long id);

    void updateByExample(ExamPaper examPaper, ExamPaperExample example);

    List selectByExample(ExamPaperExample example);

    long countByExample(ExamPaperExample example);

    ExamPaper getById(Long id);

    void delByExample(ExamPaperExample examPaperExample);

    List<ExamPaper> getMyExamPaper() throws Exception;

    List<ExamPaper> getNotMyExamPaper() throws Exception;

    String generateDocFromBasket(String paperName) throws Exception;
}
