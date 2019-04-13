package top.sicso.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Api(tags = "首页显示模块")
@Controller
public class IndexController {

    @ApiOperation(value = "加载首页")
    @GetMapping({"/index", "", "/"})
    public String loadIndexPage() {
        return "index";
    }

    @ApiOperation(value = "加载404")
    @GetMapping("/404")
    public String loadPageNotFoundPage() {
        return "404";
    }

    @ApiOperation(value = "加载Error")
    @GetMapping("/error")
    public String loadErrorPage() {
        return "500";
    }

    @ApiOperation(value = "加载登录页面")
    @GetMapping("/login")
    public String loadLoginPage() {
        return "login";
    }


}
