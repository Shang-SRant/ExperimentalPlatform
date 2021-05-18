package com.stq.experimentalplatform.controller;


import com.stq.experimentalplatform.entity.Notice;
import com.stq.experimentalplatform.entity.User;
import com.stq.experimentalplatform.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/info")
    public String GoNoticeInfo(Model model){
        List<Notice> notices = noticeService.list();
        model.addAttribute("notices",notices);
        return "/admin/notice/info";
    }

    //系统使用说明
    @RequestMapping("/add")
    public String GoNoticeAdd(String title, String editor, HttpSession session) {
        String msg = "";
        if (title == null || editor == null) {
            msg = "信息填写不完整，添加失败！请重新添加！";
        } else {
            Notice notice = new Notice();

            User user = (User) session.getAttribute("user");

            notice.setTitle(title);
            notice.setContent(editor);
            notice.setUserId(user.getUserId());
            notice.setUpdateTime(LocalDateTime.now());
            notice.setCreateTime(LocalDateTime.now());

            noticeService.save(notice);

        }
        return "admin/notice/notice_add";
    }

    @RequestMapping("/delete/{id}")
    public String deleteNotice(@PathVariable Integer id){
        boolean b = noticeService.removeById(id);
        return "redirect:/notice/info";
    }
}

