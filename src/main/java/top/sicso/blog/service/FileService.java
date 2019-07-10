package top.sicso.blog.service;

import org.springframework.web.multipart.MultipartFile;
import top.sicso.blog.common.FileResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


public interface FileService {

    /**
     * 博客中的图片上传
     *
     * @return
     */
    FileResult uploadBlogPicture(String picPath, MultipartFile picture, HttpServletRequest request);


//    FileResult loadBlogPicture();

}
