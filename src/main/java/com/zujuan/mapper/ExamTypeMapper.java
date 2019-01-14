package com.zujuan.mapper;

import com.zujuan.pojo.ExamType;
import com.zujuan.pojo.ExamTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamTypeMapper {
    long countByExample(ExamTypeExample example);

    int deleteByExample(ExamTypeExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(ExamType record);

    int insertSelective(ExamType record);

    List<ExamType> selectByExample(ExamTypeExample example);

    ExamType selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") ExamType record, @Param("example") ExamTypeExample example);

    int updateByExample(@Param("record") ExamType record, @Param("example") ExamTypeExample example);

    int updateByPrimaryKeySelective(ExamType record);

    int updateByPrimaryKey(ExamType record);

    List<ExamType> listAll();
}