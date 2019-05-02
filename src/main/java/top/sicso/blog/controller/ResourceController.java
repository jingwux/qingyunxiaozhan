package top.sicso.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.sicso.blog.service.ResourceService;

@Api(value = "/", tags = "资源显示模块")
@Controller
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation(value = "获取资源列表")
    @RequestMapping("/resource")
    public String loadResourcePage(){
        return "projects";
    }


}
