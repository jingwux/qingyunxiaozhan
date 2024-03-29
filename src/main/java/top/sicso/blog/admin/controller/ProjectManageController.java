package top.sicso.blog.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.sicso.blog.common.ResultBean;
import top.sicso.blog.pojo.Project;
import top.sicso.blog.service.ProjectService;
import top.sicso.blog.vo.BlogCondition;
import top.sicso.blog.vo.BlogVO;
import top.sicso.blog.vo.ProjectCondition;
import top.sicso.blog.vo.ProjectVO;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


@Api(value = "/", tags = "项目管理模块")
@Controller
@RequestMapping("/admin")
public class ProjectManageController {

    @Autowired
    private ProjectService projectService;

    @ApiOperation(value = "加载推荐项目页面", notes = "加载推荐项目页面")
    @GetMapping("/project")
    public String loadProjectPage(ProjectCondition projectCondition, Model model) {
        Page<ProjectVO> projects = projectService.getProject(projectCondition);
        model.addAttribute("projects", projects);
        return "admin/project";
    }


    @ApiOperation(value = "Json推荐项目列表", notes = "Json推荐项目列表")
    @ApiImplicitParam(name = "推荐项目列表", value = "推荐项目列表", paramType = "query", dataType = "top.sicso.blog.pojo.ProjectCondition")
    @GetMapping("/projects")
    @ResponseBody
    public ResultBean projectJsonList(ProjectCondition projectCondition) {
        ResultBean result = new ResultBean();
        result.setData(projectService.getProject(projectCondition));
        result.setSuccess(ResultBean.SUCCESS);
        return result;
    }

    @ApiOperation(value = "加载推荐项目", notes = "根据项目ID加载项目数据")
    @ApiImplicitParam(name = "推荐项目ID", value = "项目ID", required = true, paramType = "path", dataType = "Integer")
    @GetMapping("/project/{id}")
    @ResponseBody
    public ResultBean updateProject(@PathVariable Integer id) {
        ResultBean result = new ResultBean();
        result.setData(projectService.getProjectById(id));
        result.setSuccess(ResultBean.SUCCESS);
        return result;
    }

    @ApiOperation(value = "更新推荐项目", notes = "更新推荐项目")
    @ApiImplicitParam(name = "推荐", value = "推荐", required = true, paramType = "query", dataType = "top.sicso.blog.vo.ProjectVO")
    @PutMapping("/project")
    @ResponseBody
    public ResultBean updateProject(ProjectVO projectVO) {
        ResultBean result = new ResultBean();
        projectService.updateProject(projectVO);
        result.setSuccess(ResultBean.SUCCESS);
        return result;
    }


    @ApiOperation(value = "删除推荐项目")
    @ApiImplicitParam(name = "项目id", value = "id", required = true, paramType = "path", dataType = "Integer")
    @DeleteMapping("/project/{projectId}")
    @ResponseBody
    public ResultBean deleteProject(@PathVariable Integer projectId) {
        ResultBean resultBean = new ResultBean();
        if (projectId != null) {
            projectService.deleteProject(projectId);
        }
        resultBean.setSuccess(ResultBean.SUCCESS);
        resultBean.setMessage("删除成功");
        return resultBean;
    }

    @ApiOperation(value = "添加推荐项目", notes = "添加推荐项目")
    @ApiImplicitParam(name = "推荐项目内容", value = "项目", required = true, paramType = "query", dataType = "top.sicso.blog.vo.ProjectVO")
    @PostMapping("/project")
    @ResponseBody
    public ResultBean addProject(ProjectVO projectVO) {
        ResultBean result = new ResultBean();
        projectService.addProject(projectVO);
        result.setSuccess(ResultBean.SUCCESS);
        return result;
    }

}
