package top.sicso.blog.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ResourManageController {


    @RequestMapping("/resource")
    public String loadResourcePage(){
        return "admin/resource";
    }

}
