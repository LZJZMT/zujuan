package com.zujuan.controller;

import com.zujuan.pojo.Examination;
import com.zujuan.service.ExamBasketService;
import com.zujuan.service.ExamService;
import com.zujuan.utils.ExportDoc;
import com.zujuan.utils.GetResultBean;
import freemarker.template.Template;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/22 15:42
 */

@Controller
@RequestMapping("/paper")
public class PaperController {
    @Value("${upload.localDirectory}")
    private String localDirectory;

    @Autowired
    private ExamBasketService ebs;

    @Autowired
    private ExamService es;

    @ResponseBody
    @RequestMapping("downloadWordByIds")
    public Map downloadWord(@RequestBody Examination[] examinations){
        Map resultMap = GetResultBean.getResultMap();
        try {
            LinkedList<Examination> examList = new LinkedList<>();
            for (Examination examination : examinations) {
                examList.add(es.getById(examination.getEid()));
            }
            ExportDoc exportDoc = new ExportDoc("gb2312");
            exportDoc.set_NextPart("------=_NextPart_01D4C48A.B50DABD0");
            exportDoc.setPreFile("file:///C:/213792E5/");
            Template template = exportDoc.getTemplate("examTemplate.mht", "gb2312");

            int index = 1;
            LinkedList<String> imageBase64BlockList = new LinkedList<>();
            LinkedList<String> oFileList = new LinkedList<>();
            String fileName = "E:/image/paper/离散数学练习题"+new Date().getTime()+".doc";
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "gb2312"));
            for (Examination examination : examList) {
                String wordQuestion = exportDoc.handHtml2Word(examination.getQuestion(), imageBase64BlockList, oFileList);
                Document document = addIndexToQuestion(wordQuestion, index++);
                examination.setQuestion(document.toString());
            }

            resultMap.put("msg",fileName.substring(2));
            HashMap<String, Object> map = new HashMap<>();
            map.put("examList", examList);
            map.put("base64List", imageBase64BlockList);
            map.put("oFileList", oFileList);
            template.process(map, writer);
            writer.close();
        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            resultMap.put("msg",e.getMessage());
            e.printStackTrace();
        }finally {
            return resultMap;
        }
    }

    public Document addIndexToQuestion(String question,int index){
        Document doc = Jsoup.parse(question);
        if (doc.getElementsByTag("p") == null || doc.getElementsByTag("p").size() == 0){
            Elements body = doc.getElementsByTag("body").first().children();
            if (body == null || body.size() == 0 || doc.getElementsByTag("body").first().getElementsByTag("p").size()==0){
                doc.getElementsByTag("body").first().prependText(index + "、");
            }
            return doc;
        }
        if (doc.getElementsByTag("p").first().child(0) == null){
            return null;
        }
        Element p = doc.getElementsByTag("p").first().child(0);
        p.prependText(index + "、");
        return doc;
    }


    @ResponseBody
    @RequestMapping("/convertPaper")
    public Map converPaper() throws Exception {

        ExportDoc exportDoc = new ExportDoc("gb2312");
        exportDoc.set_NextPart("------=_NextPart_01D4C472.EB54B520");
        exportDoc.setPreFile("file:///C:/8589A2B1/");
        Template template = exportDoc.getTemplate("t1.mht", "gb2312");

        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\image\\paper\\generate.doc"), "gb2312"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("courseCode", "21312312");
        map.put("njzy", "17级软件工程");
        map.put("time", "120");
        LinkedList<String> imageBase64BlockList = new LinkedList<>();
        LinkedList<String> oFileList = new LinkedList<>();
        int index = 1;

        List<Examination> examinations = ebs.getMyExam();
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
        for (Examination examination : pdtExamList) {
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

        return GetResultBean.getResultMap();

    }


}
