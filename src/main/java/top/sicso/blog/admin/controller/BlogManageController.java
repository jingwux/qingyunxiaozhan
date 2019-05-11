package top.sicso.blog.admin.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.sicso.blog.common.ResultBean;
import top.sicso.blog.pojo.Blog;
import top.sicso.blog.pojo.Tag;
import top.sicso.blog.service.BlogService;
import top.sicso.blog.utils.ObjectUtils;
import top.sicso.blog.utils.TimeUtils;
import top.sicso.blog.vo.BlogCondition;
import top.sicso.blog.vo.BlogVO;

import java.util.List;


@Api(value = "/", tags = "博客管理模块")
@Controller
@RequestMapping("/admin")
public class BlogManageController {

    @Autowired
    private BlogService blogService;

    @ApiOperation(value = "加载博客列表页面", notes = "加载发布博客页面")
    @ApiImplicitParam(name = "博客列表", value = "博客列表", paramType = "query", dataType = "top.sicso.blog.pojo.BlogCondition")
    @GetMapping("/blog")
    public String loadBlogListPage(BlogCondition blogCondition, Model model) {
        model.addAttribute("blogs", blogService.getBlogByCondition(blogCondition));
        return "admin/blogList";
    }

    @ApiOperation(value = "Json博客列表", notes = "Json博客列表")
    @ApiImplicitParam(name = "博客列表", value = "博客列表", paramType = "query", dataType = "top.sicso.blog.pojo.BlogCondition")
    @GetMapping("/blogs")
    @ResponseBody
    public ResultBean loadBlogListPage2(BlogCondition blogCondition) {
        ResultBean result = new ResultBean();
        result.setData(blogService.getBlogByCondition(blogCondition));
        result.setSuccess(ResultBean.SUCCESS);
        return result;
    }

    @ApiOperation(value = "加载发布博客页面", notes = "加载发布博客页面")
    @GetMapping("/blog/add")
    public String loadAddBlogPage() {
        return "admin/blogAdd";
    }

    @ApiOperation(value = "发布博客", notes = "发布博客")
    @ApiImplicitParam(name = "博客内容", value = "博客相关", required = true, paramType = "query", dataType = "top.sicso.blog.pojo.Blog")
    @PostMapping("/blog")
    public String addBlog(Blog blog) {
        blog.setDate(TimeUtils.getCurrentLocalDate());
        blogService.addBlog(blog);
        return "redirect:blog";
    }


    @ApiOperation(value = "加载更新博客页面")
    @ApiImplicitParam(name = "博客内容", value = "博客相关", required = true, paramType = "path", dataType = "Integer")
    @GetMapping("/update/{id}")
    public String updateBlog(@PathVariable Integer id, Model model) {
        BlogVO blog = blogService.getBlogByBlogId(id);
        model.addAttribute("blog", blog);
        return "admin/blogUpdate";
    }



    @ApiOperation(value = "更新博客")
    @ApiImplicitParam(name = "博客内容", value = "博客相关", required = true, paramType = "query", dataType = "top.sicso.blog.pojo.Blog")
    @PutMapping("/blog")
    public String updateBlog(Blog blog, RedirectAttributes redirectAttributes) {
        if (ObjectUtils.isNotBlank(blog)) {
            if (blog.getDate() == null) blog.setDate(TimeUtils.getCurrentLocalDate());
            blogService.addBlog(blog);
            return "redirect:/admin/listBlog";
        }
        redirectAttributes.addFlashAttribute("message", "编辑博客");
        return "admin/blogUpdate";

    }

    @ApiOperation(value = "删除博客")
    @ApiImplicitParam(name = "博客id", value = "id", required = true, paramType = "path", dataType = "Integer")
    @DeleteMapping("/blog/{blogId}")
    @ResponseBody
    public ResultBean deleteBlog(@PathVariable Integer blogId) {
        ResultBean resultBean = new ResultBean();
        if (blogId != null) {
            blogService.deleteBlog(blogId);
        }
        resultBean.setSuccess(ResultBean.SUCCESS);
        resultBean.setMessage("删除成功");
        return resultBean;

    }




}
