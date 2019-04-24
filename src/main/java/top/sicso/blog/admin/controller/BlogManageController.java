package top.sicso.blog.admin.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.sicso.blog.pojo.Blog;
import top.sicso.blog.service.BlogService;
import top.sicso.blog.utils.ObjectUtils;
import top.sicso.blog.vo.BlogCondition;


@Api(value = "/", tags = "博客管理模块")
@Controller
@RequestMapping("/admin")
public class BlogManageController {

    @Autowired
    private BlogService blogService;

    @ApiOperation(value = "加载博客列表页面", notes = "加载发布博客页面")
    @ApiImplicitParam(name = "博客列表", value = "博客列表", paramType = "query", dataType = "top.sicso.blog.pojo.BlogCondition")
    @GetMapping("/listBlog")
    public String loadBlogListPage(BlogCondition blogCondition, Model model) {
        if (blogCondition.getPageSize() == 0) blogCondition.setPageSize(15);
        model.addAttribute("blogs", blogService.getBlogByCondition(blogCondition));
        return "admin/listBlog";
    }

    @ApiOperation(value = "加载发布博客页面", notes = "加载发布博客页面")
    @GetMapping("/blog")
    public String loadAddBlogPage() {
        return "admin/blog";
    }


    @ApiOperation(value = "添加博客")
    @ApiImplicitParam(name = "博客内容", value = "博客相关", required = true, paramType = "query", dataType = "top.sicso.blog.pojo.Blog")
    @PostMapping("/addBlog")
    public String addBlog(Blog blog, RedirectAttributes redirectAttributes) {
        if (ObjectUtils.isNotBlank(blog)) {
            blogService.addBlog(blog);
            return "redirect:/admin/listBlog";
        }
        redirectAttributes.addFlashAttribute("message", "编辑博客");
        return "admin/blog";

    }

    @GetMapping("/blog/{blogId}")
    public String loadBlogByBlogId(@PathVariable Integer blogId, Model model) {
        model.addAttribute("blog", blogService.getBlogByBlogId(blogId));
        return "admin/blog";
    }

}