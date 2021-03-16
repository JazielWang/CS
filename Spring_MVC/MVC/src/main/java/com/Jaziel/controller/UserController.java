package com.Jaziel.controller;

import com.Jaziel.Dao.Imp.UserDao;
import com.Jaziel.Dao.VO;
import com.Jaziel.POJO.User;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王杰
 * @time 2020/10/11 17:40
 */
@Controller
public class UserController {
    @RequestMapping(value = "/quick24")
    public String save24(Model model) {
        model.addAttribute("user", new User());
        return "spittles";
    }

    @RequestMapping(value = "/quick22")
    @ResponseBody
    public void save22(String name, MultipartFile[] update) throws IOException {
        System.out.println(name);
        /*获得上传文件名称*/
        for (MultipartFile multipartFile : update) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("E:\\Google\\" + originalFilename));
        }
    }

    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(String name, MultipartFile update, MultipartFile update2) throws IOException {
        System.out.println(name);
        /*获得上传文件名称*/
        String originalFilename = update.getOriginalFilename();
        update.transferTo(new File("E:\\Google\\" + originalFilename));
        String originalFilename2 = update2.getOriginalFilename();
        update2.transferTo(new File("E:\\Google\\" + originalFilename2));
    }

    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@CookieValue("JSESSIONID") String cookieVale) throws JsonProcessingException {
        System.out.println(cookieVale);
    }

    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(@RequestHeader(value = "User-Agent", required = false) String user_agent) throws JsonProcessingException {
        System.out.println(user_agent);
    }

    @RequestMapping(value = "/quick23")
    @ResponseBody
    public void save23(HttpServletResponse response, HttpServletRequest request, HttpSession session) throws IOException {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Data data) throws JsonProcessingException {
        System.out.println(data);
    }

    /**
     * http://localhost:9080/quick17/zhangsan
     */
    @RequestMapping(value = "/quick17/{name}")
    @ResponseBody
    public void save17(@PathVariable(value = "name") String name) throws JsonProcessingException {
        System.out.println(name);
    }

    @RequestMapping(value = "/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "username", required = false, defaultValue = "itcase") String name) throws JsonProcessingException {
        System.out.println(name);
    }

    //请求参数

    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(@RequestBody List<UserDao> user) throws JsonProcessingException {
        System.out.println(user);
    }

    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(VO vo) throws JsonProcessingException {
        System.out.println(vo);
    }

    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(String[] strs) throws JsonProcessingException {
        System.out.println(Arrays.toString(strs));
    }

    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(UserDao user) throws JsonProcessingException {
        System.out.println(user);
    }

    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(String name, int age) throws JsonProcessingException {
        System.out.println(name);
        System.out.println(age);
    }

    //回写数据

    @RequestMapping(value = "/quick10")
    @ResponseBody
    public UserDao save10() throws JsonProcessingException {
        UserDao user = new UserDao();
        user.setAge(23);
        user.setName("lj");
        return user;
    }

    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        UserDao user = new UserDao();
        user.setAge(23);
        user.setName("lj");
        // 使用 json 转换工具将对象准换为 String 然后返回
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8() {
        return "{\"username\":\"Jaziel\", \"age\":23}";
    }

    @RequestMapping(value = "/quick7")
    /**
     @ResponseBody 告诉spring框架不进行视图跳转，直接进行数据响应；之前都是警醒跳转拼接 .jsp
     */
    @ResponseBody
    public String save7() {
        return "hello, wj.";
    }

    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello, Jaziel.");
    }

    //页面跳转

    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request) {
        request.setAttribute("username", "dqy");
        return "success";
    }

    @RequestMapping(value = "/quick4")
    public String save4(Model model) {
        model.addAttribute("username", "wj");
        return "success";
    }

    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {
        modelAndView.addObject("username", "lj");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick2")
    public ModelAndView save2() {
        /*
          model：模型 作用：封装数据
          view：视图 作用：展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        /*设置模型数据*/
        modelAndView.addObject("username", "Jaziel");
        /*设置视图名称*/
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = ("username"))
    /**输入网址的时候，必须输入 params http://localhost:9080/quick?username 中的字符*/
    public String save() {
        System.out.println("controller is running...");
        // 如果在类上使用 RequestMapping 必须要在返回文件前面加 /
        // /jsp/success.jsp
        return "success";
    }
}