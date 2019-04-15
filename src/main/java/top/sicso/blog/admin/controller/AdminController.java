package top.sicso.blog.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.sicso.blog.pojo.Blog;
import top.sicso.blog.service.AdminService;
import top.sicso.blog.service.BlogService;
import top.sicso.blog.vo.BlogVO;

@Api(value = "/", tags = "博客管理模块")
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private BlogService blogService;

    @ApiOperation(value = "加载管理系统首页", notes = "加载管理系统首页2")
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "admin/index";
    }

    @ApiOperation(value = "加载发布博客页面", notes = "加载发布博客页面")
    @GetMapping("/addBlogPage")
    public String loadAddBlogPage() {
        return "admin/addBlog";
    }

    @ApiOperation(value = "加载博客列表页面", notes = "加载发布博客页面")
    @GetMapping("/listBlogPage")
    public String loadBlogListPage() {
        return "admin/listBlog";
    }

    @ApiOperation(value = "加载项目页面", notes = "加载发布博客页面")
    @GetMapping("/projectPage")
    public String loadProjectPage() {
        return "admin/project";
    }

    @ApiOperation(value = "添加博客")
    @ApiImplicitParam(name = "博客内容", value = "博客相关", required = true, paramType = "query", dataType = "top.sicso.blog.pojo.Blog")
    @PostMapping("/addBlog")
    public String addBlog(Blog blog) {

        return "";
    }

}
