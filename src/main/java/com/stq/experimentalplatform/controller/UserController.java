package com.stq.experimentalplatform.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.stq.experimentalplatform.entity.User;
import com.stq.experimentalplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/password")
    public String password() {
        return "admin/modify_password/modify_password";
    }

    @RequestMapping("/info")
    public String info(HttpSession session) {
        return "admin/info/user_info";
    }

    @RequestMapping("/modify/password")
    public String modify_info(Integer userId, String old_password, String new_password, String confirm_password, HttpSession session) {
        User user = new User();
        user.setUserId(userId);

        String msg = "";

        if (!old_password.equals(userService.getById(user).getPassword())) {
            msg = "原始密码比对失败，请重试！";
        } else if (!new_password.equals(confirm_password)) {
            msg = "修改的密码前后不一致！请重试！";
        } else {
            user.setPassword(confirm_password);
            msg = "密码修改成功！重新登陆！";
        }


        session.setAttribute("msg", msg);

        return "redirect:/login";
    }

    @RequestMapping("/modify/info")
    public String modify_info(User user, HttpSession session) {
        String msg = "";
        boolean b = userService.updateById(user);
        if (b) {
            msg = "修改成功,重新登录！";
        } else {
            msg = "修改失败,重新登录！";
        }
        session.setAttribute("msg", msg);
        return "redirect:/login";
    }

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

    @RequestMapping("/manager/info")
    public String managerUserInfo(Model model) {
        List<User> users = userService.list();
        model.addAttribute("users", users);
        return "/admin/user/info";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        boolean b = userService.removeById(id);
        return "redirect:/user/manager/info";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "/admin/user/edit";
    }

    @RequestMapping("/edit/post")
    public String modifyUser(User user) {
        userService.updateById(user);
        return "redirect:/user/manager/info";
    }

    @RequestMapping("/add")
    public String addUser() {
        return "/admin/user/add";
    }

    @RequestMapping("/add/post")
    public String addUser(User user) {
        userService.save(user);
        return "redirect:/user/manager/info";
    }
}

