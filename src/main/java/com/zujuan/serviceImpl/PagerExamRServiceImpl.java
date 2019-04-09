package com.zujuan.serviceImpl;

import com.zujuan.mapper.PagerExamRMapper;
import com.zujuan.mapper.PagerExamRMapper;
import com.zujuan.pojo.PagerExamR;
import com.zujuan.pojo.PagerExamRExample;
import com.zujuan.pojo.PagerExamR;
import com.zujuan.pojo.PagerExamRExample;
import com.zujuan.service.PagerExamRService;
import com.zujuan.utils.GetCurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: lizijian
 * @Date： 2019/4/9 14:32
 */
@Service
public class PagerExamRServiceImpl implements PagerExamRService {

    @Autowired
    public PagerExamRMapper mapper;

    @Override
    public void add(PagerExamR pagerExamR) {
        mapper.insertSelective(pagerExamR);
    }

    @Override
    public void del(Long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateByExample(PagerExamR pagerExamR, PagerExamRExample example) {
        mapper.updateByExampleSelective(pagerExamR,example);
    }

    @Override
    public List selectByExample(PagerExamRExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public long countByExample(PagerExamRExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public PagerExamR getById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void delByExample(PagerExamRExample pagerExamRExample) {
        mapper.deleteByExample(pagerExamRExample);
    }
}
