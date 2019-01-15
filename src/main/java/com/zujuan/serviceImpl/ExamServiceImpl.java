package com.zujuan.serviceImpl;

import com.zujuan.mapper.ExaminationMapper;
import com.zujuan.mapper.KnowledgeMapper;
import com.zujuan.pojo.Examination;
import com.zujuan.pojo.ExaminationExample;
import com.zujuan.pojo.PageBean;
import com.zujuan.service.ExamService;
import com.zujuan.utils.BeanUtil;
import com.zujuan.vo.ExaminationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/15 15:32
 */

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExaminationMapper em;
    @Autowired
    private KnowledgeMapper km;

    @Override
    public PageBean list(Examination examination, Integer page, Integer limit) {
        PageBean pageBean = new PageBean();
        if (examination == null) {
            List<Examination> list = em.list((page - 1) * limit, limit);
            List<ExaminationVO> examinationVOS = BeanUtil.copyList(list, ExaminationVO.class);

            for (ExaminationVO examVO : examinationVOS){
                examVO.setZsdname(km.selectByPrimaryKey(examVO.getKnowId()).getZsdname());
            }
            pageBean.setData(examinationVOS);
            long l = em.countByExample(new ExaminationExample());
            pageBean.setCount(String.valueOf(l));
        }
        return pageBean;
    }

    @Override
    public void add(Examination examination) {
        em.insert(examination);
    }

    @Override
    public void del(Long id) {
        em.deleteByPrimaryKey(id);
    }

    @Override
    public void updateByExample(Examination examination, ExaminationExample example) {
        em.updateByExampleSelective(examination, example);
    }

    @Override
    public List selectByExample(ExaminationExample example) {
        return em.selectByExample(example);
    }

    @Override
    public long countByExample(ExaminationExample example) {
        return em.countByExample(example);
    }
}
