package com.Jaziel.test;

import com.Jaziel.controller.UserController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


/**
 * @author 王杰
 * @date 2021/3/10 15:18
 */
public class UserControllerTest {
    @Test
    public void test1() throws Exception {
        UserController controller = new UserController();
        // 搭建MockMvc
        MockMvc mockMvc = standaloneSetup(controller).build();
        // 对 /quick?username 执行 get请求，预期得到 success 视图
        mockMvc.perform(get("/quick?username")).andExpect(view().name("success"));
    }

    @Test
    public void test2() throws Exception {
        UserController controller = new UserController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/quick2")).andExpect(view().name("success"));
    }

    @Test
    public void test4() throws Exception {
        UserController controller = new UserController();
        // 搭建MockMvc
        MockMvc mockMvc = standaloneSetup(controller).build();
        // 对 /quick?username 执行 get请求，预期得到 success 视图
        mockMvc.perform(get("/quick4")).andExpect(view().name("success"))
                // 检验 model 存在 username
                .andExpect(model().attributeExists("username"));
    }
}