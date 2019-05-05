package top.sicso.blog.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.sicso.blog.common.ResultBean;
import top.sicso.blog.service.FileService;

@Service
public class FileServiceImpl implements FileService {


    @Override
    public ResultBean uploadBlogPicture(String picPath, MultipartFile picture) {

        return null;
    }
}
