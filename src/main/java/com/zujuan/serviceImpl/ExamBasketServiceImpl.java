package com.zujuan.serviceImpl;

import com.zujuan.mapper.ExamBasketMapper;
import com.zujuan.mapper.ExaminationMapper;
import com.zujuan.pojo.ExamBasket;
import com.zujuan.pojo.ExamBasketExample;
import com.zujuan.pojo.Examination;
import com.zujuan.service.ExamBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/18 15:37
 */

@Service
public class ExamBasketServiceImpl implements ExamBasketService {

    @Autowired
    private ExamBasketMapper ebm;
    @Autowired
    private ExaminationMapper em;

    @Override
    public void add(ExamBasket examBasket) {
        ebm.insert(examBasket);
    }

    @Override
    public void del(Long id) {
        ebm.deleteByPrimaryKey(id);
    }

    @Override
    public void updateByExample(ExamBasket examBasket, ExamBasketExample example) {
        ebm.updateByExampleSelective(examBasket, example);
    }

    @Override
    public List selectByExample(ExamBasketExample example) {
        return ebm.selectByExample(example);
    }

    @Override
    public long countByExample(ExamBasketExample example) {
        return ebm.countByExample(example);
    }

    @Override
    public ExamBasket getById(Long id) {
        return ebm.selectByPrimaryKey(id);
    }

    @Override
    public void delByExample(ExamBasketExample examBasketExample) {
        ebm.deleteByExample(examBasketExample);
    }

    @Override
    public List<Examination> getMyExam() {
        List<ExamBasket> examBaskets = ebm.selectAll();
        List<Examination> examinations = new ArrayList<Examination>();
        for (ExamBasket examBasket : examBaskets) {
            examinations.add(em.selectByPrimaryKey(examBasket.getExamId()));
        }
        return examinations;
    }
}