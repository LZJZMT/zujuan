package com.zujuan.mapper;

import com.zujuan.pojo.Knowledge;
import com.zujuan.pojo.KnowledgeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KnowledgeMapper {
    long countByExample(KnowledgeExample example);
    int deleteByExample(KnowledgeExample example);
    int deleteByPrimaryKey(Long id);
    int insert(Knowledge record);
    int insertSelective(Knowledge record);
    List<Knowledge> selectByExample(KnowledgeExample example);
    Knowledge selectByPrimaryKey(Long id);
    int updateByExampleSelective(@Param("record") Knowledge record, @Param("example") KnowledgeExample example);
    int updateByExample(@Param("record") Knowledge record, @Param("example") KnowledgeExample example);
    int updateByPrimaryKeySelective(Knowledge record);
    int updateByPrimaryKey(Knowledge record);
    List list(Integer start, Integer limit);
    List getParentIdisNull();
}