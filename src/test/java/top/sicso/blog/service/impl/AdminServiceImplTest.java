package top.sicso.blog.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.sicso.blog.InitTest;
import top.sicso.blog.pojo.Admin;
import top.sicso.blog.admin.service.AdminService;

import static org.junit.Assert.*;

@Slf4j
public class AdminServiceImplTest extends InitTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void add() throws JSONException {
        Admin admin = new Admin();
        admin.setUsername("myyl");
        admin.setPassword("1234");
        JSONObject info = new JSONObject();
        info.put("github", "yuanqingx@aliyun.com");
        info.put("linkedin", "yuanqingx@aliyun.com");
        log.info(info.toString());
        admin.setInfo(info.toString());
        adminService.add(admin);
    }

    @Test
    public void login() {
        boolean flag = adminService.login("myyl", "1234");
        assertTrue(flag);

    }


}