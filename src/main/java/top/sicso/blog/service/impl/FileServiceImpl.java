package top.sicso.blog.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.sicso.blog.common.FileResult;
import top.sicso.blog.service.FileService;
import top.sicso.blog.utils.FileUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


@Service
public class FileServiceImpl implements FileService {


    @Override
    public FileResult uploadBlogPicture(String picPath, MultipartFile picture, HttpServletRequest request) {
        FileResult fileResult = new FileResult();

        try {
            String url = FileUtils.uploadPicture(picPath, picture);
            fileResult.setUrl(url);
            fileResult.setSuccess(FileResult.SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileResult;
    }
}
