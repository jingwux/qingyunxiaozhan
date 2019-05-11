package top.sicso.blog.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "/", tags = "资源管理模块")
@Controller
@RequestMapping("/admin")
public class ResourceManageController {

    @ApiOperation(value = "加载资源页面", notes = "加载资源页面")
    @GetMapping("/resource")
    public String loadResourcePage(){
        return "admin/resource";
    }

}
