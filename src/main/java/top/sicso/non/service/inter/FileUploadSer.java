package top.sicso.non.service.inter;

import top.sicso.blog.pojo.Info;
import top.sicso.blog.vo.UploadPic;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface FileUploadSer {
    UploadPic uploadPic(HttpServletRequest request);

    Info updateAvatar(HttpServletRequest request);

    ResponseEntity<byte[]> gainPic(String dir, String picName);
}
