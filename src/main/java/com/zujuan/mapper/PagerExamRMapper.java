package com.zujuan.mapper;

import com.zujuan.pojo.PagerExamR;
import com.zujuan.pojo.PagerExamRExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PagerExamRMapper {
    long countByExample(PagerExamRExample example);

    int deleteByExample(PagerExamRExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PagerExamR record);

    int insertSelective(PagerExamR record);

    List<PagerExamR> selectByExample(PagerExamRExample example);

    PagerExamR selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PagerExamR record, @Param("example") PagerExamRExample example);

    int updateByExample(@Param("record") PagerExamR record, @Param("example") PagerExamRExample example);

    int updateByPrimaryKeySelective(PagerExamR record);

    int updateByPrimaryKey(PagerExamR record);
}