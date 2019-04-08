package top.sicso.blog.controller;


import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.sicso.blog.service.BlogService;
import top.sicso.blog.vo.ArchiveVO;

@Api(value = "/", tags = "博客显示模块")
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @ApiOperation(value = "分页获取博客归档")
    @ApiImplicitParam(name = "pageIndex", value = "分页页码", dataType = "int", paramType = "path")
    @GetMapping(value = "/archives/{pageIndex}")
    public String loadArchivesPage(@PathVariable int pageIndex, Model model) {
        PageInfo<ArchiveVO> archivesOrderByMonth = blogService.getArchivesOrderByMonth(pageIndex);
        model.addAttribute("title", "随笔归档");
        model.addAttribute("archives", archivesOrderByMonth);
        return "archives";
    }

    @ApiOperation(value = "获取博客标签")
    @GetMapping(value = "/tags")
    public String loadTagsPage(Model model) {
        model.addAttribute("title", "分类标签");
        model.addAttribute("tags", blogService.getAllTags());
        return "tags";
    }

    @ApiOperation(value = "根据标签查询博客")
    @ApiImplicitParam(name = "tagName", value = "博客标签", required = true, dataType = "String", paramType = "path")
    @GetMapping(value = "/blog/{tagName}")
    public String getBlogByTagName(Model model, @PathVariable String tagName) {
        model.addAttribute("title", "博客");
        model.addAttribute("tagName", tagName);
        model.addAttribute("tags", blogService.getBlogByTagName(tagName));
        return "tagView";
    }


}
