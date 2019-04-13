package top.sicso.blog.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import top.sicso.blog.InitTest;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BlogControllerTest extends InitTest {

    @Test
    public void getBlogByTagName() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("http://localhost/blog/java"))
                .andExpect(status().isOk()) // 断言
                .andDo(print())             // 打印请求响应信息
                .andReturn();               // 返回一个结果对象

        mvcResult.getModelAndView();
        mvcResult.getResponse().getContentAsString();
    }
}