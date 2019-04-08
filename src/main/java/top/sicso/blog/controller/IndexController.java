package top.sicso.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "首页显示模块")
@Controller
public class IndexController {

    @ApiOperation(value = "加载首页")
    @GetMapping("/index")
    public String loadIndexPage() {
        return "index";
    }


}
