package top.sicso.blog.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "/", tags = "博客显示模块")
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping({"/", ""})
    public String index() {
        return "admin/monitor";
    }

    @ApiOperation(value = "加载登录页面")
    @GetMapping("/login")
    public String loadLoginPage() {
        return "redirect:/login";
    }

}
