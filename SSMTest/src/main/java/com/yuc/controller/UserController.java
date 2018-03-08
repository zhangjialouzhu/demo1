package com.yuc.controller;

import com.yuc.model.User;
import com.yuc.service.UserService;
import com.yuc.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public ModelAndView index(){
        User user = new User();
        user.setId(UUIDUtil.uuid());
        user.setName("yuc");
        userService.insert(user);
        return new ModelAndView("index");
    }

}
