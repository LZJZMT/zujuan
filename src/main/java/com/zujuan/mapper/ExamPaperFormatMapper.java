package com.zujuan.mapper;

import com.zujuan.pojo.ExamPaperFormat;
import com.zujuan.pojo.ExamPaperFormatExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamPaperFormatMapper {
    long countByExample(ExamPaperFormatExample example);

    int deleteByExample(ExamPaperFormatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExamPaperFormat record);

    int insertSelective(ExamPaperFormat record);

    List<ExamPaperFormat> selectByExample(ExamPaperFormatExample example);

    ExamPaperFormat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExamPaperFormat record, @Param("example") ExamPaperFormatExample example);

    int updateByExample(@Param("record") ExamPaperFormat record, @Param("example") ExamPaperFormatExample example);

    int updateByPrimaryKeySelective(ExamPaperFormat record);

    int updateByPrimaryKey(ExamPaperFormat record);
}