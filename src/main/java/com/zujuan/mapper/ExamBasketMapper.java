package com.zujuan.mapper;

import com.zujuan.pojo.ExamBasket;
import com.zujuan.pojo.ExamBasketExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ExamBasketMapper {
    long countByExample(ExamBasketExample example);

    int deleteByExample(ExamBasketExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExamBasket record);

    int insertSelective(ExamBasket record);

    List<ExamBasket> selectByExample(ExamBasketExample example);

    ExamBasket selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExamBasket record, @Param("example") ExamBasketExample example);

    int updateByExample(@Param("record") ExamBasket record, @Param("example") ExamBasketExample example);

    int updateByPrimaryKeySelective(ExamBasket record);

    int updateByPrimaryKey(ExamBasket record);

    List<ExamBasket> selectAll();
}