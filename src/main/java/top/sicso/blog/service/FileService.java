package top.sicso.blog.service;

import org.springframework.web.multipart.MultipartFile;
import top.sicso.blog.common.ResultBean;

import javax.servlet.http.HttpServletRequest;

public interface FileService {

    /**
     * 博客中的图片上传
     * @return
     */
    ResultBean uploadBlogPicture(String picPath, MultipartFile picture);

}
