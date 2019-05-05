package top.sicso.blog.admin.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import top.sicso.blog.common.ResultBean;

import javax.servlet.http.HttpServletRequest;

@Api(value = "", tags = "文件上传下载")
@Controller
public class FileController  {

    @PutMapping("/admin/file/upload")
    public ResultBean uploadPic(HttpServletRequest request){
        return null;
    }

}
