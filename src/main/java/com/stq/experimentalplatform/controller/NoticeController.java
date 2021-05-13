package com.stq.experimentalplatform.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    //系统使用说明
    @RequestMapping("/add")
    public String GoNoticeAdd() {
        return "admin/notice/notice_add";
    }

}

