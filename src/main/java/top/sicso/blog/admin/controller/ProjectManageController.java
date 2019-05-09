package top.sicso.blog.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sicso.blog.common.ResultBean;
import top.sicso.blog.service.ProjectService;
import top.sicso.blog.vo.BlogCondition;
import top.sicso.blog.vo.BlogVO;
import top.sicso.blog.vo.ProjectCondition;
import top.sicso.blog.vo.ProjectVO;


@Api(value = "/", tags = "项目管理模块")
@Controller
@RequestMapping("/admin")
public class ProjectManageController {

    @Autowired
    private ProjectService projectService;

    @ApiOperation(value = "加载项目页面", notes = "加载发布博客页面")
    @GetMapping("/project")
    public String loadProjectPage(ProjectCondition projectCondition, Model model) {
        Page<ProjectVO> projects = projectService.getProject(projectCondition);
        model.addAttribute("projects", projects);
        return "admin/project";
    }


    @ApiOperation(value = "Json项目列表", notes = "Json项目列表")
    @ApiImplicitParam(name = "项目列表", value = "项目列表", paramType = "query", dataType = "top.sicso.blog.pojo.ProjectCondition")
    @GetMapping("/projects")
    @ResponseBody
    public ResultBean projectJsonList(ProjectCondition projectCondition) {
        ResultBean result = new ResultBean();
        result.setData(projectService.getProject(projectCondition));
        result.setSuccess(ResultBean.SUCCESS);
        return result;
    }

    @ApiOperation(value = "加载更新博客页面")
    @ApiImplicitParam(name = "博客内容", value = "博客相关", required = true, paramType = "path", dataType = "Integer")
    @GetMapping("/project/{id}")
    @ResponseBody
    public ResultBean updateBlog(@PathVariable Integer id) {
        ResultBean result = new ResultBean();
        result.setData(projectService.getProjectById(id));
        result.setSuccess(ResultBean.SUCCESS);
        return result;
    }


}
