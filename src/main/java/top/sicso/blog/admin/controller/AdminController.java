package top.sicso.blog.admin.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.sicso.blog.pojo.Admin;
import top.sicso.blog.pojo.Blog;
import top.sicso.blog.admin.service.AdminService;
import top.sicso.blog.service.BlogService;
import top.sicso.blog.vo.BlogCondition;
import top.sicso.blog.vo.BlogVO;

@Api(value = "/", tags = "博客管理模块")
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private BlogService blogService;

    @ApiOperation(value = "加载管理系统首页", notes = "加载管理系统首页")
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "admin/index";
    }


    @ApiOperation(value = "个人资料", notes = "加载个人资料")
    @RequestMapping(value = "/info", method = {RequestMethod.GET, RequestMethod.POST})
    public String info(Model model) {
        Admin admin = adminService.getAdmin();
        model.addAttribute("admin", admin);
        return "admin/info";
    }


}
