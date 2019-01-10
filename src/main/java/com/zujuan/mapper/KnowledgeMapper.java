package com.zujuan.mapper;

import com.zujuan.pojo.Knowledge;
import com.zujuan.pojo.KnowledgeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KnowledgeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbg.generated
     */
    long countByExample(KnowledgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbg.generated
     */
    int deleteByExample(KnowledgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbg.generated
     */
    int insert(Knowledge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbg.generated
     */
    int insertSelective(Knowledge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbg.generated
     */
    List<Knowledge> selectByExample(KnowledgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbg.generated
     */
    Knowledge selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Knowledge record, @Param("example") KnowledgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Knowledge record, @Param("example") KnowledgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Knowledge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Knowledge record);

    List list(Integer start, Integer limit);
}