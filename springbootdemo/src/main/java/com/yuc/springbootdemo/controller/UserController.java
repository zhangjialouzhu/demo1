package com.yuc.springbootdemo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuc.springbootdemo.model.User;
import com.yuc.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum, String id,String action){
        ModelAndView modelAndView = new ModelAndView();
        if ("up".equals(action)){
            pageNum --;
        }
        if ("down".equals(action)){
            pageNum ++;
        }
        PageHelper.startPage(pageNum,6);
        List<User> users = userService.getById(id);
        for (User user :users){
            System.out.println(user.getName());
        }
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return modelAndView.addObject("user",pageInfo).addObject("users",users);
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("/index");
        for (int i = 0; i <100 ; i++) {
            User user = new User();
            user.setId("id"+i);
            user.setName("yuc"+i);

            userService.insert(user);
        }
        return modelAndView;
    }

}
