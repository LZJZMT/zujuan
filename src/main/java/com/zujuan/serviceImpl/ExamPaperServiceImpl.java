package com.zujuan.serviceImpl;

import com.zujuan.controller.ExamPaperController;
import com.zujuan.mapper.ExamPaperMapper;
import com.zujuan.pojo.ExamPaper;
import com.zujuan.pojo.ExamPaperExample;
import com.zujuan.pojo.Examination;
import com.zujuan.service.ExamBasketService;
import com.zujuan.service.ExamPaperService;
import com.zujuan.utils.CommonUtils;
import com.zujuan.utils.ExportDoc;
import com.zujuan.utils.GetCurrentUser;
import freemarker.template.Template;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;
import java.util.concurrent.*;

/**
 * @Description:
 * @Author: lizijian
 * @Date： 2019/4/9 13:54
 */

@Service
public class ExamPaperServiceImpl implements ExamPaperService {

    @Autowired
    private ExamPaperMapper mapper;

    @Autowired
    private ExamBasketService ebs;

    @Value("${upload.staticMapping}")
    private String staticMapping;

    @Value(("${upload.localDirectory}"))
    private String localDirectory;


    @Override
    public String generateDocFromBasket(String paperName, ExamPaper examPaper) throws Exception {
        ExportDoc exportDoc = new ExportDoc("gb2312");
        exportDoc.set_NextPart("------=_NextPart_01D4C472.EB54B520");
        exportDoc.setPreFile("file:///C:/8589A2B1/");
        Template template = exportDoc.getTemplate("t1.mht", "gb2312");
        String fileNameByNowDateTime = CommonUtils.getFileNameByNowDateTime()+"_"+ (int)((Math.random()*9+1)*1000000);
        String fileUrl = "exampaper/" + fileNameByNowDateTime+paperName + (int) (100000 * Math.random()) + ".doc";
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(localDirectory + fileUrl), "gb2312"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("courseCode", examPaper.getCourseCode());
        map.put("njzy", examPaper.getNjzy());
        map.put("time", examPaper.getTime());
        LinkedList<String> imageBase64BlockList = new LinkedList<>();
        LinkedList<String> oFileList = new LinkedList<>();
        int index = 1;

        List<Examination> examinations = ebs.getMyExam();
        if (examinations == null || examinations.size() == 0) {
            examinations = ExamPaperController.examinations;
        }
        ArrayList<Examination> xztExamList = new ArrayList<>();
        ArrayList<Examination> tktExamList = new ArrayList<>();
        ArrayList<Examination> pdtExamList = new ArrayList<>();
        ArrayList<Examination> wdtExamList = new ArrayList<>();
        for (Examination examination : examinations) {

            if (examination.getType() == 1) {
                xztExamList.add(examination);
            } else if (examination.getType() == 2) {
                tktExamList.add(examination);
            } else if (examination.getType() == 3) {
                pdtExamList.add(examination);
            } else if (examination.getType() == 4) {
                wdtExamList.add(examination);
            }
        }
        for (Examination examination : xztExamList) {
            String wordQuestion = exportDoc.handHtml2Word(examination.getQuestion(), imageBase64BlockList, oFileList);
            Document document = addIndexToQuestion(wordQuestion, index++);
            examination.setQuestion(document.toString());
        }
        for (Examination examination : tktExamList) {
            String wordQuestion = exportDoc.handHtml2Word(examination.getQuestion(), imageBase64BlockList, oFileList);
            StringBuilder sb = new StringBuilder(wordQuestion);//构造一个StringBuilder对象
            Document document = addIndexToQuestion(wordQuestion, index++);
            examination.setQuestion(document.toString());
        }
        for (
                Examination examination : pdtExamList) {
            String wordQuestion = exportDoc.handHtml2Word(examination.getQuestion(), imageBase64BlockList, oFileList);
            StringBuilder sb = new StringBuilder(wordQuestion);//构造一个StringBuilder对象
            Document document = addIndexToQuestion(wordQuestion, index++);
            examination.setQuestion(document.toString());
        }
        for (Examination examination : wdtExamList) {
            String wordQuestion = exportDoc.handHtml2Word(examination.getQuestion(), imageBase64BlockList, oFileList);
            StringBuilder sb = new StringBuilder(wordQuestion);//构造一个StringBuilder对象
            Document document = addIndexToQuestion(wordQuestion, index++);
            examination.setQuestion(document.toString());
        }
        HashMap<Object, String> xiaoxie2daxie = new HashMap<>();
        xiaoxie2daxie.put(1, "一、选择题");
        xiaoxie2daxie.put(2, "二、填空题");
        xiaoxie2daxie.put(3, "三、判断题");
        xiaoxie2daxie.put(4, "四、问答题");


        map.put("xuanzeti", xztExamList.size() > 0 ? xiaoxie2daxie.get(1) : "");
        map.put("tiankongti", tktExamList.size() > 0 ? xiaoxie2daxie.get(2) : "");
        map.put("panduanti", pdtExamList.size() > 0 ? xiaoxie2daxie.get(3) : "");
        map.put("wendati", wdtExamList.size() > 0 ? xiaoxie2daxie.get(4) : "");
        map.put("xztExamList", xztExamList);
        map.put("tktExamList", tktExamList);
        map.put("pdtExamList", pdtExamList);
        map.put("wdtExamList", wdtExamList);
        map.put("base64List", imageBase64BlockList);
        map.put("oFileList", oFileList);
        template.process(map, writer);

        writer.close();

        return staticMapping.replace("*", "") + fileUrl;
    }

    @Override
    public void add(ExamPaper examPaper) {
        mapper.insertSelective(examPaper);
    }

    @Override
    public void del(Long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateByExample(ExamPaper examPaper, ExamPaperExample example) {
        mapper.updateByExampleSelective(examPaper, example);
    }

    @Override
    public List selectByExample(ExamPaperExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public long countByExample(ExamPaperExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public ExamPaper getById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void delByExample(ExamPaperExample examPaperExample) {
        mapper.deleteByExample(examPaperExample);
    }

    @Override
    public List<ExamPaper> getMyExamPaper() throws Exception {
        ExamPaperExample paperExample = new ExamPaperExample();
        paperExample.createCriteria().andAuthorIdEqualTo(GetCurrentUser.getCurrentUser().getId());
        return mapper.selectByExample(paperExample);
    }

    @Override
    public List<ExamPaper> getNotMyExamPaper() throws Exception {
        ExamPaperExample paperExample = new ExamPaperExample();
        paperExample.createCriteria().andAuthorIdNotEqualTo(GetCurrentUser.getCurrentUser().getId());
        return mapper.selectByExample(paperExample);
    }


    @Override
    public Document addIndexToQuestion(String question, int index) {
        Document doc = Jsoup.parse(question);
        if (doc.getElementsByTag("span").size() > 0) {
            doc.getElementsByTag("span").first().prependText(index + "、");
        } else if (doc.getElementsByTag("p").size() > 0) {
            Elements pChildren = doc.getElementsByTag("p").first().children();
            if (pChildren.size() > 0){
                pChildren.first().prependText(index + "、");
            }else {
                doc.getElementsByTag("p").first().text(index + "、"+doc.getElementsByTag("p").first().text());
            }
        } else {
            question = index + "、" + question;
            doc = Jsoup.parse(question);
        }
        return doc;
    }
    public static void main(String[] args) {

        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(10);
        newScheduledThreadPool.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " "+new Date().toLocaleString());
            }
        },0,1,TimeUnit.SECONDS);

    }
}
