package com.zujuan.controller;

import com.alibaba.fastjson.JSONArray;
import com.zujuan.mapper.ExamPaperFormatMapper;
import com.zujuan.mapper.ExamPaperMapper;
import com.zujuan.pojo.*;
import com.zujuan.service.*;
import com.zujuan.serviceImpl.ExamPaperData;
import com.zujuan.utils.BeanUtil;
import com.zujuan.utils.GetCurrentUser;
import com.zujuan.utils.GetResultBean;
import com.zujuan.utils.ResultViewMap;
import com.zujuan.vo.ExamPaperVO;
import com.zujuan.vo.ExaminationVO;
import com.zujuan.vo.PagerExamRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @Description:
 * @Author: lizijian
 * @Date： 2019/4/9 9:01
 */

@RequestMapping("/examPaper")
@Controller
public class ExamPaperController {

    @Autowired
    private ExamService examService;

    @Autowired
    private ExamPaperService examPaperService;

    @Autowired
    private PagerExamRService pagerExamRService;

    @Autowired
    private ExamBasketService examBasketService;

    @Autowired
    private UserService userService;

    @Autowired
    private KnowledgeService ks;

    @Autowired
    private ExamPaperFormatMapper examPaperFormatMapper;

    @Autowired
    private ExamPaperMapper examPaperMapper;

    public static List<Examination> examinations = null;

    @ResponseBody
    @RequestMapping("/getAllPaper")
    public List getAllPaper(){
        List<ExamPaperFormat> examPaperFormats = examPaperFormatMapper.selectByExample(null);
        ArrayList<ExamPaper> examPapers1 = new ArrayList<>();
        for (ExamPaperFormat examPaperFormat : examPaperFormats) {
            ExamPaperExample examPaperExample = new ExamPaperExample();
            examPaperExample.createCriteria().andPidEqualTo(examPaperFormat.getPaperId());
            List<ExamPaper> examPapers = examPaperMapper.selectByExample(examPaperExample);
            if (examPapers!=null && examPapers.size()>0){
                examPapers1.add(examPapers.get(0));
            }
        }
        return examPapers1;
    }

    @ResponseBody
    @RequestMapping("/getAllPaper2")
    public List getAllPaper2(){
        List<ExamPaper> examPapers = examPaperMapper.selectByExample(null);
        return examPapers;
    }

    @ResponseBody
    @RequestMapping("/MyExamPaperList")
    public PageBean MyExamPaperList(String njzy,String name) {
        ExamPaperFormatExample example = new ExamPaperFormatExample();

        try {
            User user = GetCurrentUser.getCurrentUser();

            example.createCriteria().andAuthorIdEqualTo(user.getId());
            List<ExamPaperFormat> formatList = examPaperFormatMapper.selectByExample(example);
            List<ExamPaper> myExamPaper = new ArrayList<>();
            for (ExamPaperFormat examPaperFormat : formatList) {

                ExamPaperExample examPaperExample = new ExamPaperExample();
                ExamPaperExample.Criteria criteria = examPaperExample.createCriteria();
                criteria.andPidEqualTo(examPaperFormat.getPaperId());
                if(!("".equals(name) ||name == null)){
                    criteria.andNameLike("%"+name+"%");
                }
                if(!("".equals(njzy) ||njzy == null)){
                    criteria.andNjzyLike("%"+njzy+"%");
                }
                List<ExamPaper> examPapers = examPaperMapper.selectByExample(examPaperExample);
                if(examPapers ==null || examPapers.size()==0){
                    continue;
                }

                myExamPaper.add(examPapers.get(0));
                criteria = null;
            }
            List<ExamPaperVO> examPaperVOS = BeanUtil.copyList(myExamPaper, ExamPaperVO.class);
            for (ExamPaperVO examPaper : examPaperVOS) {
                Long authorId = examPaper.getAuthorId();
                UserExample userExample = new UserExample();
                userExample.createCriteria().andIdEqualTo(authorId);
                List<User> list = userService.queryByExample(userExample);
                if (list != null && list.size() > 0) {
                    examPaper.setAuthorName(list.get(0).getUsername());
                }
            }
            Collections.reverse(examPaperVOS);
            PageBean pageBean = new PageBean();
            pageBean.setCount(examPaperVOS.size()+"");
            pageBean.setCode("0");
            pageBean.setMsg("成功");
            pageBean.setData(examPaperVOS);
            return pageBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @ResponseBody
    @RequestMapping("/delExam")
    public Map delExamPaper(Long pid){
        Map resultMap = GetResultBean.getResultMap();
        try {
            examPaperMapper.deleteByPrimaryKey(pid);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap = GetResultBean.getFailResultMap();
        }finally {
            return resultMap;
        }

    }


    @ResponseBody
    @RequestMapping("/delMyFormExam")
    public Map delMyFormExam(Long pid){
        Map resultMap = GetResultBean.getResultMap();
        ExamPaperFormatExample example = new ExamPaperFormatExample();
        User user ;
        try {
            user = GetCurrentUser.getCurrentUser();
            example.createCriteria().andAuthorIdEqualTo(user.getId())
                    .andPaperIdEqualTo(pid);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",1);
            resultMap.put("msg","请先登录");return resultMap;
        }
        try {
            examPaperFormatMapper.deleteByExample(example);
            resultMap.put("msg","删除成功");

        } catch (Exception e){
            resultMap.put("code",1);
            resultMap.put("msg","删除失败");
            e.printStackTrace();
        }finally {
            return resultMap;
        }

    }

    @ResponseBody
    @RequestMapping("/addMyFormExam")
    public Map addMyFormExam(Long pid){
        Map resultMap = GetResultBean.getResultMap();
        ExamPaperFormatExample example = new ExamPaperFormatExample();
        User user ;
        try {
            user = GetCurrentUser.getCurrentUser();
            example.createCriteria().andAuthorIdEqualTo(user.getId())
            .andPaperIdEqualTo(pid);
        } catch (Exception e) {
            resultMap.put("msg","请先登录");return resultMap;
        }
        List<ExamPaperFormat> list = examPaperFormatMapper.selectByExample(example);
        if (list!= null && list.size()>0){
            resultMap.put("msg","已添加成功，请勿重复添加");
            return resultMap;
        }
        ExamPaperFormat examPaperFormat = new ExamPaperFormat();
        examPaperFormat.setAuthorId(user.getId());
        examPaperFormat.setPaperId(pid);
        try {
            examPaperFormatMapper.insert(examPaperFormat);
            resultMap.put("msg","添加成功");
        } catch (Exception e){
            resultMap.put("msg","添加失败");
            e.printStackTrace();
        }finally {
            return resultMap;
        }

    }

    @ResponseBody
    @RequestMapping("fenxi")
    public List<Map> fenxi(Long pid){

        ExamPaper examPaper = examPaperService.getById(pid);
        PagerExamRExample examRExample = new PagerExamRExample();
        examRExample.createCriteria().andPidEqualTo(pid);

        List<PagerExamR> list = pagerExamRService.selectByExample(examRExample);
        int xz = 0;
        int tk = 0;
        int pd = 0;
        int wd = 0;

        int jd = 0;
        int yb = 0;
        int jn = 0;
        int kn = 0;
        HashMap<Object, Integer> zsd = new HashMap<>();

        for (PagerExamR pagerExamR : list) {
            Long eid = pagerExamR.getEid();
            Examination examination = examService.getById(eid);
            Long knowId = examination.getKnowId();
            Knowledge knowledge = ks.selectByPrimary(knowId);
            String zsdname = knowledge.getZsdname();
            int i = zsd.get(zsdname) == null ? 0 : zsd.get(zsdname);
            zsd.put(zsdname,++i);
            switch (examination.getDegree().intValue()){
                case 1:jd++;break;
                case 2:yb++;break;
                case 3:jn++;break;
                case 4:kn++;break;
            }

            switch (examination.getType()){
                case 1:xz++;break;
                case 2:tk++;break;
                case 3:pd++;break;
                case 4:wd++;break;
            }
        }

        HashMap<Object, Object> tixing = new HashMap<>();
        tixing.put("xz",xz);
        tixing.put("tk",tk);
        tixing.put("pd",pd);
        tixing.put("wd",wd);
        tixing.put("name",examPaper.getName());

        HashMap<Object, Object> nandu = new HashMap<>();
        nandu.put("jd",jd);
        nandu.put("yb",yb);
        nandu.put("jn",jn);
        nandu.put("kn",kn);
        nandu.put("name",examPaper.getName());

        ArrayList<Map> maps = new ArrayList<>();
        maps.add(tixing);
        maps.add(nandu);
        maps.add(zsd);

        return maps;
    }


    @ResponseBody
    @RequestMapping("duibifenxi")
    public Map duibifenxi(Long pid1,Long pid2){

        PagerExamRExample examRExample1 = new PagerExamRExample();
        examRExample1.createCriteria().andPidEqualTo(pid1);
        List<PagerExamR> list1 = pagerExamRService.selectByExample(examRExample1);
        PagerExamRExample examRExample2 = new PagerExamRExample();
        examRExample2.createCriteria().andPidEqualTo(pid2);
        List<PagerExamR> list2 = pagerExamRService.selectByExample(examRExample2);
        int xz = 0;
        int tk = 0;
        int pd = 0;
        int wd = 0;

        int jd = 0;
        int yb = 0;
        int jn = 0;
        int kn = 0;
        HashMap<Object, Integer> zsd = new HashMap<>();

        for (PagerExamR pagerExamR : list1) {
            Long eid = pagerExamR.getEid();
            Examination examination = examService.getById(eid);
            Long knowId = examination.getKnowId();
            Knowledge knowledge = ks.selectByPrimary(knowId);
            String zsdname = knowledge.getZsdname();
            int i = zsd.get(zsdname) == null ? 0 : zsd.get(zsdname);
            zsd.put(zsdname,++i);
            switch (examination.getDegree().intValue()){
                case 1:jd++;break;
                case 2:yb++;break;
                case 3:jn++;break;
                case 4:kn++;break;
            }

            switch (examination.getType()){
                case 1:xz++;break;
                case 2:tk++;break;
                case 3:pd++;break;
                case 4:wd++;break;
            }
        }
        ArrayList<Integer> p1tx = new ArrayList<>();
        ArrayList<Integer> p2tx = new ArrayList<>();
        ArrayList<Integer> p1nd = new ArrayList<>();
        ArrayList<Integer> p2nd = new ArrayList<>();
        p1tx.add(xz);p1tx.add(tk);p1tx.add(pd); p1tx.add(wd);
        p1nd.add(jd);p1nd.add(yb);p1nd.add(jn);p1nd.add(kn);
        xz = 0;        tk = 0;        pd = 0;        wd = 0;
        jd = 0;        yb = 0;        jn = 0;        kn = 0;
        for (PagerExamR pagerExamR : list2) {
            Long eid = pagerExamR.getEid();
            Examination examination = examService.getById(eid);
            Long knowId = examination.getKnowId();
            Knowledge knowledge = ks.selectByPrimary(knowId);
            String zsdname = knowledge.getZsdname();
            int i = zsd.get(zsdname) == null ? 0 : zsd.get(zsdname);
            zsd.put(zsdname,++i);
            switch (examination.getDegree().intValue()){
                case 1:jd++;break;
                case 2:yb++;break;
                case 3:jn++;break;
                case 4:kn++;break;
            }

            switch (examination.getType()){
                case 1:xz++;break;
                case 2:tk++;break;
                case 3:pd++;break;
                case 4:wd++;break;
            }
        }
        p2tx.add(xz);p2tx.add(tk);p2tx.add(pd); p2tx.add(wd);
        p2nd.add(jd);p2nd.add(yb);p2nd.add(jn);p2nd.add(kn);

        HashMap hashMap = new HashMap();
        hashMap.put("p1nd",p1nd);
        hashMap.put("p2nd",p2nd);
        hashMap.put("p1tx",p1tx);
        hashMap.put("p2tx",p2tx);
        return hashMap;
    }

    @RequestMapping("/autoExamPaper")
    public String previewPaper(ModelMap modelMap) {
        Map typeViewMap = ResultViewMap.getTypeViewMap();
        Map degreeViewMap = ResultViewMap.getDegreeViewMap();


        List<Examination> examinations = this.examinations;
        ArrayList<ExaminationVO> list = new ArrayList<ExaminationVO>();
        for (Examination examination : examinations) {
            ExaminationVO examinationVO = BeanUtil.copy(examination, ExaminationVO.class);
            examinationVO.setTypeString((String) typeViewMap.get(examinationVO.getType()));
            examinationVO.setDegreeString((String) degreeViewMap.get(examinationVO.getDegree()));
            //解析JSONString为Map
            String optionJson = examinationVO.getOptionJson();
            Map map = (Map) JSONArray.parse(optionJson);
            if (map != null) {
                examinationVO.setOptionC((String) map.get("C"));
                examinationVO.setOptionD((String) map.get("D"));
                examinationVO.setOptionA((String) map.get("A"));
                examinationVO.setOptionB((String) map.get("B"));
            }
            examinationVO.setZsdname(ks.selectByPrimary(examinationVO.getKnowId()).getZsdname());
            list.add(examinationVO);
        }
        modelMap.addAttribute("voList", list);
        return "previewPaper";
    }

    //生成题目信息
    @ResponseBody
    @RequestMapping("/autoZujuan")
    public Map autoZujuan(String numOfAuto,String know_ids){

        ArrayList<Examination> examinations;
        try {

            String[] zsdIdsStr = know_ids.split(",");
            Long[] zsdIds = new Long[zsdIdsStr.length];
            for (int i = 0; i < zsdIdsStr.length; i++) {
                zsdIds[i] = Long.decode(zsdIdsStr[i]);
            }
            List<Long> zsdIdList = new ArrayList();

            for (Long zsdId : zsdIds) {
                zsdIdList.add(zsdId);
            }
            KnowledgeExample knowledgeExample = new KnowledgeExample();
            knowledgeExample.createCriteria().andParentidIn(zsdIdList);
            List<Knowledge> knowledgeList = ks.selectByExample(knowledgeExample);
            for (Knowledge knowledge : knowledgeList) {
                zsdIdList.add(knowledge.getId());
            }
            HashSet h = new HashSet(zsdIdList);
            zsdIdList.clear();
            zsdIdList.addAll(h);
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (Long zsdId : zsdIdList){
                sb.append(zsdId);
                sb.append(",");
            }
            sb.append("-1");
            sb.append(")");

            String[] split = numOfAuto.split(",");
            ArrayList<Integer> list = new ArrayList<>();
            for (String s : split) {
                list.add(Integer.valueOf(s));
            }

            examinations = new ArrayList<>();
            System.out.println(sb.toString());
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == 0) continue;
                examinations.addAll(examService.selectByExampleLimit(i/4+1,(double)i%4+1,list.get(i),sb.toString()));
            }
            if (examinations.size() == 0){
                throw new RuntimeException("未找到合适的题目，请变更条件重试");
            }
            ExamPaperController.examinations = examinations;
        }catch (Exception e){
            Map failResultMap = GetResultBean.getFailResultMap();
            failResultMap.put("msg",e.getMessage());
            return failResultMap;
        }
        return GetResultBean.getResultMap();

    }

    @RequestMapping("/examPaperList")
    public String examPaperList(ModelMap modelMap) {
        try {
            List<ExamPaper> notMyExamPaper = examPaperService.getNotMyExamPaper();
            List<ExamPaper> myExamPaper = examPaperService.getMyExamPaper();
            notMyExamPaper.addAll(myExamPaper);
            List<ExamPaperVO> examPaperVOS = BeanUtil.copyList(notMyExamPaper, ExamPaperVO.class);
            for (ExamPaperVO examPaper : examPaperVOS) {
                Long authorId = examPaper.getAuthorId();
                UserExample userExample = new UserExample();
                userExample.createCriteria().andIdEqualTo(authorId);
                List<User> list = userService.queryByExample(userExample);
                if (list != null && list.size() > 0) {
                    examPaper.setAuthorName(list.get(0).getUsername());
                }

            }
            Collections.reverse(examPaperVOS);
            modelMap.addAttribute("examPaperList", examPaperVOS);
        } catch (Exception e) {
            return "redirect:/views/user/login.html";
        }
        return "examPaperList";
    }

    @RequestMapping("/myExamPaper")
    public String myExamPaper(ModelMap modelMap) {
        List<ExamPaper> myExamPaperList = null;
        try {
            myExamPaperList = examPaperService.getMyExamPaper();
            List<ExamPaperVO> examPaperVOS = BeanUtil.copyList(myExamPaperList, ExamPaperVO.class);
            for (ExamPaperVO examPaperVO : examPaperVOS) {
                examPaperVO.setAuthorName(GetCurrentUser.getCurrentUser().getUsername());
            }
            Collections.reverse(myExamPaperList);
            modelMap.addAttribute("examPaperList", examPaperVOS);
        } catch (Exception e) {
            return "redirect:/views/user/login.html";
        }

        return "examPaperList";
    }

    @ResponseBody
    @RequestMapping("/addExamPaperR")
    public Map saveExamScore(PagerExamRVO e) {
        Map resultMap = GetResultBean.getResultMap();
        ExamPaperData.list = e.getExamPaper();
        return null;
    }

    @ResponseBody
    @RequestMapping("/addExamPaper")
    public Map saveExamPaper(ExamPaper examPaper) throws Exception {
        Map resultMap = GetResultBean.getResultMap();
        examPaper.setAuthorId(GetCurrentUser.getCurrentUser().getId());
        examPaper.setCreateTime(new Date());
        List<PagerExamR> list = ExamPaperData.list;
        if (list == null || list.size() == 0) {
            return GetResultBean.getFailResultMap();
        }
        double degree = 0d;
        int totalScore = 0;
        for (PagerExamR pagerExamR : list) {
            Long eid = pagerExamR.getEid();
            Examination examServiceById = examService.getById(eid);
            degree += examServiceById.getDegree();
            if (pagerExamR.getScore() != null) {
                totalScore += pagerExamR.getScore();
            }

        }
        DecimalFormat df = new DecimalFormat("#.0");
        Double format = Double.valueOf(df.format(degree / list.size()));
        examPaper.setDegree(format);
        examPaper.setTotalScore(totalScore == 0 ? 100 : totalScore);
        String file_url = examPaperService.generateDocFromBasket(examPaper.getName(),examPaper);
        examPaper.setFileUrl(file_url);
        examPaperService.add(examPaper);

        for (PagerExamR pagerExamR : list) {
            pagerExamR.setId(null);
            pagerExamR.setPid(examPaper.getPid());
            pagerExamRService.add(pagerExamR);
        }

        //删除试题蓝的试题
        ExamBasketExample basketExample = new ExamBasketExample();
        basketExample.createCriteria().andUserIdEqualTo(GetCurrentUser.getCurrentUser().getId());
        examBasketService.delByExample(basketExample);

        return resultMap;
    }

}
