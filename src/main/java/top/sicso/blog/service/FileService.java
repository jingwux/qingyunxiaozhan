package top.sicso.blog.service;

import org.springframework.web.multipart.MultipartFile;
import top.sicso.blog.common.FileResult;

import javax.servlet.http.HttpServletRequest;

public interface FileService {

    /**
     * 博客中的图片上传
     *
     * @return
     */
    FileResult uploadBlogPicture(String picPath, MultipartFile picture, HttpServletRequest request);

}
