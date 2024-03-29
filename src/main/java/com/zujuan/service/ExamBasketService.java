package com.zujuan.service;

import com.zujuan.pojo.ExamBasket;
import com.zujuan.pojo.ExamBasketExample;
import com.zujuan.pojo.Examination;

import java.util.List;

public interface ExamBasketService {

    void add(ExamBasket examBasket);


    void del(Long id);

    void updateByExample(ExamBasket examBasket, ExamBasketExample example);

    List selectByExample(ExamBasketExample example);

    long countByExample(ExamBasketExample example);

    ExamBasket getById(Long id);

    void delByExample(ExamBasketExample examBasketExample);

    List<Examination> getMyExam();
}
