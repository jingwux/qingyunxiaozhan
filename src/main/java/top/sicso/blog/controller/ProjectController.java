package top.sicso.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.sicso.blog.service.ProjectsService;

@Api(tags = "项目显示模块")
@Controller
@RequestMapping
public class ProjectController {

    @Autowired
    private ProjectsService projectsService;

    @ApiOperation(value = "加载项目列表显示页面")
    @GetMapping("/projects")
    public String loadProjectPage(Model model) {
        model.addAttribute("title", "项目列表");
        return "projects";
    }


    @ApiOperation(value = "根据项目名查找项目")
    @ApiImplicitParam(name = "projectName", value = "项目名", required = false, dataType = "String", paramType = "path")
    @GetMapping("/projects/{projectName}")
    public String listProjects(@PathVariable String projectName, Model model) {
        model.addAttribute("title", projectName);
//        model.addAttribute("projecs", projectsService.findAll());
        return "projects";
    }


}




