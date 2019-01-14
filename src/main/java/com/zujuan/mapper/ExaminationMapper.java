package com.zujuan.mapper;

import com.zujuan.pojo.Examination;
import com.zujuan.pojo.ExaminationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExaminationMapper {
    long countByExample(ExaminationExample example);

    int deleteByExample(ExaminationExample example);

    int deleteByPrimaryKey(Long eid);

    int insert(Examination record);

    int insertSelective(Examination record);

    List<Examination> selectByExampleWithBLOBs(ExaminationExample example);

    List<Examination> selectByExample(ExaminationExample example);

    Examination selectByPrimaryKey(Long eid);

    int updateByExampleSelective(@Param("record") Examination record, @Param("example") ExaminationExample example);

    int updateByExampleWithBLOBs(@Param("record") Examination record, @Param("example") ExaminationExample example);

    int updateByExample(@Param("record") Examination record, @Param("example") ExaminationExample example);

    int updateByPrimaryKeySelective(Examination record);

    int updateByPrimaryKeyWithBLOBs(Examination record);

    int updateByPrimaryKey(Examination record);
}