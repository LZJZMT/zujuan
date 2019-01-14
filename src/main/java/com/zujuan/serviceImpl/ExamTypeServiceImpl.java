package com.zujuan.serviceImpl;

import com.zujuan.mapper.ExamTypeMapper;
import com.zujuan.pojo.ExamType;
import com.zujuan.service.ExamTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/14 16:59
 */
@Service
public class ExamTypeServiceImpl implements ExamTypeService {

    @Autowired
    private ExamTypeMapper examTypeMapper;

    @Override
    public List<ExamType> listAll() {
        return examTypeMapper.listAll();
    }
}
