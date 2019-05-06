package top.sicso.non.service;

import lombok.extern.slf4j.Slf4j;
import top.sicso.blog.pojo.Info;
import top.sicso.blog.pojo.SystemSetting;
import top.sicso.blog.vo.UploadPic;
import top.sicso.non.service.inter.FileUploadSer;
import top.sicso.non.service.inter.InfoSer;
import top.sicso.blog.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Slf4j
@Service
public class FileUploadSerImpl implements FileUploadSer {
    private InfoSer infoSer;

    private SystemSetting setting;

    @Autowired
    public FileUploadSerImpl(SystemSetting setting){
//        this.infoSer = infoSer;
        this.setting = setting;
    }

    @Override
    public UploadPic uploadPic(HttpServletRequest request){

        String picUrl="";
        try {
//            picUrl= FileUtils.uploadPicture("/pic/",setting.getPicHome(),request);
        } catch (Exception e) {
           log.warn("上传图片时发生错误:"+e.getLocalizedMessage());
        }
        final UploadPic upload = new UploadPic();
        if ("".equals(picUrl)){
            upload.setSuccess(0);
            upload.setMessage("Upload picture fail!");
            upload.setUrl("");
            return upload;
        }
        upload.setSuccess(1);
        upload.setMessage("Upload picture success!");
        upload.setUrl(picUrl);
        return upload;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Info updateAvatar(HttpServletRequest request){
        String url=uploadPic(request).getUrl();
        if (!"".equals(url)){
            infoSer.updateAvatar(url);
        }
        return infoSer.getInfo();
    }

    @Override
    public ResponseEntity<byte[]> gainPic(String dir, String picName){
        File file=new File(setting.getPicHome()+File.separatorChar+dir+File.separatorChar+picName);
        byte[] bytes;
        try {
            bytes= FileUtils.readFileToByteArray(file);
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", picName);
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}
