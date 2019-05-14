package com.zujuan.controller;

import com.zujuan.mapper.ScoreMapper;
import com.zujuan.pojo.*;
import com.zujuan.service.ExamPaperService;
import com.zujuan.utils.BeanUtil;
import com.zujuan.utils.GetResultBean;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/5/11 12:08
 */
@ResponseBody
@RequestMapping("/score")
@Controller
public class ScoreController {

    @Autowired
    private ScoreMapper sm;
    @Autowired
    private ExamPaperService examPaperService;

    @ResponseBody
    @RequestMapping("/duibifenduan")
    public Map duibifenduan(Long pid1,Long pid2){
        int[] scoreDuan1 = new int[10];
        int[] scoreDuan2 = new int[10];
        ScoreExample scoreExample = new ScoreExample();
        scoreExample.createCriteria().andPidEqualTo(pid1);
        List<Score> scores = sm.selectByExample(scoreExample);

        ScoreExample scoreExample2 = new ScoreExample();
        scoreExample2.createCriteria().andPidEqualTo(pid2);
        List<Score> scores2 = sm.selectByExample(scoreExample2);
        int num1 = 0;
        int num2 = 0;
        for (Score score : scores) {
            int i = score.getScore().intValue() / 10;
            scoreDuan1[i>9?9:i]++;
            if (score.getScore().intValue() <60){
                num1++;
            }
        }
        ArrayList<Integer> jige = new ArrayList<>();
        for (Score score : scores2) {
            int i = score.getScore().intValue() / 10;
            scoreDuan2[i>9?9:i]++;
            if (score.getScore().intValue() <60){
                num2++;
            }
        }
        jige.add(num1);
        jige.add(scores.size()-num1);
        jige.add(num2);
        jige.add(scores2.size()-num2);
        List<Integer> resultList = new ArrayList<Integer>(scoreDuan1.length);
        for (int s : scoreDuan1) {
            resultList.add(s);
        }

        List<Integer> resultList2 = new ArrayList<Integer>(scoreDuan2.length);
        for (int s : scoreDuan2) {
            resultList2.add(s);
        }

        /*resultList.add(num);
        resultList.add(scores.size()-num);*/
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("p1",resultList);
        hashMap.put("p2",resultList2);
        hashMap.put("jige",jige);
        return hashMap;
    }

    @ResponseBody
    @RequestMapping("/fenduan")
    public List fenduan(Long pid){
        int[] scoreDuan = new int[10];
        ScoreExample scoreExample = new ScoreExample();
        scoreExample.createCriteria().andPidEqualTo(pid);
        List<Score> scores = sm.selectByExample(scoreExample);
        int num = 0;
        for (Score score : scores) {
            int i = score.getScore().intValue() / 10;
            scoreDuan[i>9?9:i]++;
            if (score.getScore().intValue() <60){
                num++;
            }
        }
        List<Integer> resultList = new ArrayList<Integer>(scoreDuan.length);
        for (int s : scoreDuan) {
            resultList.add(s);
        }

        resultList.add(num);
        resultList.add(scores.size()-num);
        return resultList;
    }
    //搜索和获取所有知识点
    @RequestMapping("/list")
    public PageBean list(Score score, Integer page, Integer limit){
        PageBean pageBean = new PageBean();
        List list;
        if (score == null || (StringUtils.isEmpty(score.getName())
                &&score.getXuehao()==null&&score.getPid()==null)) {
            list = sm.list((page - 1) * limit, limit);
            pageBean.setCount(sm.countByExample(null) + "");
            pageBean.setMsg("ok");
            pageBean.setCode("0");
        }else{
            ScoreExample example = new ScoreExample();
            ScoreExample.Criteria criteria = example.createCriteria();
            if (score.getXuehao() != null){
                criteria.andXuehaoEqualTo(score.getXuehao());
            }
            if (!StringUtils.isEmpty(score.getName())){
                criteria.andNameLike("%"+score.getName()+"%");
            }
            if (score.getPid()!=null){
                criteria.andPidEqualTo(score.getPid());
            }

            list = sm.selectByExample(example);
            pageBean.setCount(String.valueOf(sm.countByExample(example)));
        }

        List<ScoreVO> scoreVOS = BeanUtil.copyList(list, ScoreVO.class);
        for (ScoreVO scoreVO : scoreVOS) {
            ExamPaperExample examPaperExample = new ExamPaperExample();
            examPaperExample.createCriteria().andPidEqualTo(scoreVO.getPid());
            List<ExamPaper> list1 = examPaperService.selectByExample(examPaperExample);
            if (list1!= null && list1.size()>0){
                scoreVO.setExamName(list1.get(0).getName());
            }

        }
        pageBean.setData(scoreVOS);
        return pageBean;

    }

    //根据ID删除知识点
    @RequestMapping("/delById")
    public Map delById(Long id){
        Map resultMap = GetResultBean.getResultMap();
        try {
            sm.deleteByPrimaryKey(id);
        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            resultMap.put("msg","删除失败");
        }
        return resultMap;
    }

    //导入xlsx文件
    @RequestMapping("/uploadScoreByFile")
    @Transactional
    public Map uploadScoreByFile(Long pid,@RequestParam(value = "file") MultipartFile file){
        Map resultMap = GetResultBean.getResultMap();
        Map failResultMap = GetResultBean.getFailResultMap();
        if (!(file.getOriginalFilename().toLowerCase().endsWith("xlsx"))){
            failResultMap.put("msg","文件格式不正确,请导入xlsx文件");
            return failResultMap;
        }
        InputStream is = null;
        Workbook wb = null;
        Sheet sheet = null;
        try {
            is = file.getInputStream();
            wb = new XSSFWorkbook(is);
            sheet = wb.getSheetAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);//通过sheet表单对象得到 行对象
            if (row == null){
                continue;
            }
            if (row.getCell(0).getCellTypeEnum().getCode()!= CellType.NUMERIC.getCode()){
                failResultMap.put("msg","第"+r+"行数据格式错误");
                return failResultMap;
            }
            if (row.getCell(2).getCellTypeEnum().getCode()!= CellType.NUMERIC.getCode()){
                failResultMap.put("msg","第"+r+"行数据格式错误");
                return failResultMap;
            }
            Score score = new Score();
            Long xuehao = (long)row.getCell(0).getNumericCellValue();
            score.setXuehao(xuehao);
            score.setName(row.getCell(1).getStringCellValue());
            score.setScore(row.getCell(2).getNumericCellValue());
            score.setPid(pid);
            ScoreExample scoreExample = new ScoreExample();
            scoreExample.createCriteria().andPidEqualTo(pid).andXuehaoEqualTo(score.getXuehao());
            List<Score> scores = sm.selectByExample(scoreExample);
            System.out.println("即将插入"+score);
            if (scores!=null && scores.size()>0){
                score.setId(scores.get(0).getId());
                sm.updateByPrimaryKey(score);
            }else {
                sm.insert(score);
            }


        }
        return resultMap;
    }

    //更新知识点
    @RequestMapping("/updateScore")
    public Map updateZsd(Score knowledge){
        Map resultMap = GetResultBean.getResultMap();
        try {
            ScoreExample example = new ScoreExample();
            example.createCriteria().andIdEqualTo(knowledge.getId());
            sm.updateByExampleSelective(knowledge,example);
            resultMap.put("msg","更新成功");
        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            resultMap.put("msg",e.getMessage());
        }
        return resultMap;
    }

    //批量删除知识点
    @RequestMapping("/batchDel")
    public Map batchDel(@RequestBody Score[] knowledges){
        List<Score> knowledgeList = Arrays.asList(knowledges);
        Map resultMap = GetResultBean.getResultMap();
        try {
            for(Score k : knowledgeList){
                sm.deleteByPrimaryKey(k.getId());
            }

        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            resultMap.put("msg","删除失败");
        }
        return resultMap;
    }

    @RequestMapping("/add")
    public Map add(Score score){
        System.out.println(score);
        try {
            sm.insert(score);
        } catch (Exception e) {
            e.printStackTrace();
            return GetResultBean.getFailResultMap();
        }
        return GetResultBean.getResultMap();
    }
}
