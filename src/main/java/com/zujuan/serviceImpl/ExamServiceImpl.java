package com.zujuan.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.zujuan.mapper.ExamBasketMapper;
import com.zujuan.mapper.ExaminationMapper;
import com.zujuan.mapper.KnowledgeMapper;
import com.zujuan.pojo.*;
import com.zujuan.service.ExamService;
import com.zujuan.utils.BeanUtil;
import com.zujuan.utils.GetCurrentUser;
import com.zujuan.utils.ResultViewMap;
import com.zujuan.vo.ExaminationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Autowired
    private ExamBasketMapper ebm;

    @Override
    public PageBean list(Examination examination, Integer page, Integer limit) {
        PageBean pageBean = new PageBean();
        if (examination == null) {
            List<Examination> list = em.list((page - 1) * limit, limit);
            List<ExaminationVO> examinationVOS = BeanUtil.copyList(list, ExaminationVO.class);
            Map typeViewMap = ResultViewMap.getTypeViewMap();
            Map degreeViewMap = ResultViewMap.getDegreeViewMap();
            for (ExaminationVO examVO : examinationVOS){
                examVO.setZsdname(km.selectByPrimaryKey(examVO.getKnowId()).getZsdname());
                examVO.setTypeString((String)typeViewMap.get(examVO.getType()));
                examVO.setDegreeString((String)degreeViewMap.get(examVO.getDegree()));
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

    @Override
    public Examination getById(Long id) {
        return em.selectByPrimaryKey(id);
    }

    @Override
    public PageBean selectByConditionPage(Long[] ids, Examination exam, Integer curPage, Integer limit) throws Exception {

        //获取试题篮已经存在的试题id
        ExamBasketExample basketExample = new ExamBasketExample();
        basketExample.createCriteria().andUserIdEqualTo(GetCurrentUser.getCurrentUser().getId());
        List<ExamBasket> examBaskets = ebm.selectByExample(basketExample);
        Long [] notInIds = new Long[examBaskets.size()];
        int index = 0;
        for (ExamBasket examBasket : examBaskets) {
            notInIds[index++] = examBasket.getExamId();
        }
        if (examBaskets.size() == 0){
            notInIds = null;
        }


        List examinationList = em.listByConditionPage(ids,notInIds, exam, (curPage - 1) * limit, limit);
        List<ExaminationVO> examinationVOS = BeanUtil.copyList(examinationList, ExaminationVO.class);
        for (ExaminationVO vo : examinationVOS) {
            if (vo.getAnswer()!= null && vo.getAnswer().length() > 18){
                vo.setAnswer(vo.getAnswer().substring(0,18)+"...");
            }
            //解析JSONString为Map
            String optionJson = vo.getOptionJson();
            Map map = (Map) JSONArray.parse(optionJson);
            if(map != null){
                vo.setOptionA((String)map.get("A"));
                vo.setOptionB((String)map.get("B"));
                vo.setOptionC((String)map.get("C"));
                vo.setOptionD((String)map.get("D"));
            }

            //转成VO类
            vo.setTypeString((String) ResultViewMap.getTypeViewMap().get(vo.getType()));
            vo.setDegreeString((String) ResultViewMap.getDegreeViewMap().get(vo.getDegree()));
            vo.setZsdname(km.selectByPrimaryKey(vo.getKnowId()).getZsdname());
        }
        Long countLong = em.countByConditionPage(ids,notInIds, exam);
        PageBean pageBean = new PageBean(String.valueOf(countLong),examinationVOS);


        return pageBean;
    }

    @Override
    public List<ExaminationVO> convert2VOlist(List<Examination> examinations) {

        List<ExaminationVO> examinationVOS = BeanUtil.copyList(examinations, ExaminationVO.class);
        for (ExaminationVO vo : examinationVOS) {
            //解析JSONString为Map
            String optionJson = vo.getOptionJson();
            Map map = (Map) JSONArray.parse(optionJson);
            if(map != null){
                vo.setOptionD((String)map.get("D"));
                vo.setOptionA((String)map.get("A"));
                vo.setOptionB((String)map.get("B"));
                vo.setOptionC((String)map.get("C"));
            }
        }
        return examinationVOS;
    }
}
