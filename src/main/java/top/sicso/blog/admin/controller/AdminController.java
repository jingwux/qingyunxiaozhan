package top.sicso.blog.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    public String index(){
        return "/";
    }

    public String loadLoginPage(){
        return "/login";
    }

}
