package com.zujuan.serviceImpl;

import com.zujuan.mapper.ExamPaperMapper;
import com.zujuan.pojo.ExamPaper;
import com.zujuan.pojo.ExamPaperExample;
import com.zujuan.service.ExamPaperService;
import com.zujuan.utils.GetCurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: lizijian
 * @Date： 2019/4/9 13:54
 */

@Service
public class ExamPaperServiceImpl implements ExamPaperService {

    @Autowired
    public ExamPaperMapper mapper;

    @Override
    public void add(ExamPaper examPaper) {
        mapper.insertSelective(examPaper);
    }

    @Override
    public void del(Long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateByExample(ExamPaper examPaper, ExamPaperExample example) {
        mapper.updateByExampleSelective(examPaper,example);
    }

    @Override
    public List selectByExample(ExamPaperExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public long countByExample(ExamPaperExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public ExamPaper getById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void delByExample(ExamPaperExample examPaperExample) {
        mapper.deleteByExample(examPaperExample);
    }

    @Override
    public List<ExamPaper> getMyExamPaper() throws Exception {
        ExamPaperExample paperExample = new ExamPaperExample();
        paperExample.createCriteria().andAuthorIdEqualTo(GetCurrentUser.getCurrentUser().getId());
        return mapper.selectByExample(paperExample);
    }

    @Override
    public List<ExamPaper> getNotMyExamPaper() throws Exception {
        ExamPaperExample paperExample = new ExamPaperExample();
        paperExample.createCriteria().andAuthorIdNotEqualTo(GetCurrentUser.getCurrentUser().getId());
        return mapper.selectByExample(paperExample);
    }
}
