package com.stq.experimentalplatform.controller;

import com.stq.experimentalplatform.entity.Notice;
import com.stq.experimentalplatform.entity.Question;
import com.stq.experimentalplatform.service.NoticeService;
import com.stq.experimentalplatform.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private NoticeService noticeService;

    //首页
    @RequestMapping("/")
    public String GoIndex(Model model) {
        List<Question> questions = questionService.list();
        model.addAttribute("questions", questions);
        return "index";
    }

    //登录页
    @RequestMapping("/login")
    public String GoLogin() {
        return "login";
    }


    @RequestMapping("/admin")
    public String GoAdmin(){
        return "admin/index";
    }


    //公告
    @RequestMapping("/notice")
    public String GoNotice(Model model) {
        List<Notice> notices = noticeService.list();
        model.addAttribute("notices", notices);
        return "notice";
    }

    //系统使用说明
    @RequestMapping("/introduction")
    public String GoIntroduction() {
        return "introduction";
    }
}
