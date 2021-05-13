package com.stq.experimentalplatform.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.stq.experimentalplatform.entity.Question;
import com.stq.experimentalplatform.mapper.SQLMapper;
import com.stq.experimentalplatform.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 尚天琪
 * @since 2021-05-01
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private SQLMapper sqlMapper;

    //系统使用说明
    @RequestMapping("/databases/manager")
    public String GoIDatabasesManager() {
        return "/admin/databases/info";
    }

    //系统使用说明
    @RequestMapping("/info")
    public String GoQuestionInfo(Model model) {
        List<Question> questions = questionService.list();
        model.addAttribute("questions", questions);
        return "/admin/question/info";
    }


    @RequestMapping("/{id}")
    public String getQuestion(@PathVariable("id") String id, Model model) {
        Question question = questionService.getById(id);
        model.addAttribute("question", question);
        return "/user/question2";
    }

    @RequestMapping("/{id}/answer")
    public String checkAnswer(Model model, HttpSession session, Integer id, String sqlStr) {
        String result;

        try {
            result = sqlMapper.executeSQL(sqlStr).toString();
            try {
                QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("id", id);
                Question question = questionService.getOne(queryWrapper);
                String answer = question.getRightAnswer();

                if (result.equals(answer)) {
                    model.addAttribute("sqlStr", sqlStr);
                    model.addAttribute("info", "success");
                    session.setAttribute(id.toString(), id);
                } else {
                    model.addAttribute("sqlStr", sqlStr);
                    model.addAttribute("info", "你的输出结果是：" + result + "，这与预期的结果不符。");
                }
                return "forward:/problem/" + id;
            } catch (Exception e) {
                model.addAttribute("sqlStr", sqlStr);
                model.addAttribute("info", "你的输出结果是：" + result + "，这与预期的结果不符。");
                return "forward:/question/" + id;
            }
        } catch (Exception e) {
            model.addAttribute("sqlStr", sqlStr);
            model.addAttribute("info", e.getCause());
            return "forward:/question/" + id;
        }
    }

    @RequestMapping("/edit/{id}")
    public String editQuestion(@PathVariable Integer id, Model model) {
        Question question = questionService.getById(id);
        model.addAttribute("question", question);
        return "admin/question/edit";
    }

    @RequestMapping("/edit/post")
    public String editPostQuestion(Question question) {
        boolean b = questionService.updateById(question);
        return "admin/question/edit";
    }

}

