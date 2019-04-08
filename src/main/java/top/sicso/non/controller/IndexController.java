package top.sicso.non.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {

    @RequestMapping({"/", "/index"})
    public String loadIndexPage() {
        return "index";
    }

}
