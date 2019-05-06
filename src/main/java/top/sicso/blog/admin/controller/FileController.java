package top.sicso.blog.admin.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import top.sicso.blog.common.FileResult;
import top.sicso.blog.constant.FileHelper;
import top.sicso.blog.service.FileService;

import javax.servlet.http.HttpServletRequest;

@Api(value = "", tags = "文件上传下载")
@Controller
@RequestMapping("/admin/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/picture")
    public FileResult uploadPicture(HttpServletRequest request, MultipartFile file) {
        return fileService.uploadBlogPicture(FileHelper.PICTURE, file, request);
    }

}
