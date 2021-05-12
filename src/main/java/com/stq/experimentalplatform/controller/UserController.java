package com.stq.experimentalplatform.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.stq.experimentalplatform.entity.User;
import com.stq.experimentalplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 尚天琪
 * @since 2021-05-01
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String email, String password, HttpSession session) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", email).eq("password", password);
        User user = userService.getOne(queryWrapper);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/admin";
        } else {
            return "login";
        }
    }

}

