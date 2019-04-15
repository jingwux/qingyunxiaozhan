package top.sicso.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.sicso.blog.service.AdminService;

import javax.servlet.http.HttpSession;

@Api(tags = "首页显示模块")
@Controller
public class IndexController {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "加载首页")
    @GetMapping({"/index", "", "/"})
    public String loadIndexPage() {
        return "index";
    }

    @ApiOperation(value = "加载404")
    @GetMapping("/404")
    public String loadPageNotFoundPage() {
        return "404";
    }

    @ApiOperation(value = "加载Error")
    @GetMapping("/error")
    public String loadErrorPage() {
        return "500";
    }

    @ApiOperation(value = "加载登录页面")
    @RequestMapping("/login")
    public String loadLoginPage() {
        return "login";
    }

    @ApiOperation(value = "加载登录页面")
    @PostMapping("/login.do")
    public String login(String username, String password, HttpSession session, RedirectAttributes redirectAttributes) {
        boolean flag = adminService.login(username, password);
        if (flag) {
            session.setAttribute("admin", "admin");
            return "redirect:/admin/";
        }
        redirectAttributes.addFlashAttribute("loginMessage", "用户名或密码错误");
        return "redirect:/login";
    }

}
