package com.Jaziel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 王杰
 * @time 2020/10/16 14:01
 */
@Controller
public class UserController {
    @RequestMapping("/target")
    public ModelAndView show(){
        System.out.println("目标资源执行");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "itcast");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
