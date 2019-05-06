package top.sicso.blog.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.sicso.blog.common.FileResult;
import top.sicso.blog.service.FileService;
import top.sicso.blog.utils.FileUtils;

import javax.servlet.http.HttpServletRequest;

@Service
public class FileServiceImpl implements FileService {


    @Override
    public FileResult uploadBlogPicture(String picPath, MultipartFile picture, HttpServletRequest request) {
        FileResult fileResult = new FileResult();

//        FileUtils.updatePic();

        return null;
    }
}
