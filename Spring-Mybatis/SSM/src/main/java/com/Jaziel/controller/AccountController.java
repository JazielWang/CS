package com.Jaziel.controller;

import com.Jaziel.domain.Account;
import com.Jaziel.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/29 19:45
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**保存*/
    @RequestMapping(value = "/save", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Account account){
        accountService.save(account);
        System.out.println(account);
        return "保存成功";
    }

    /**查询*/
    @RequestMapping("/list")
    public ModelAndView list(){
        List<Account> accountList = accountService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accountList", accountList);
        modelAndView.setViewName("list");
        return modelAndView;
    }

}
