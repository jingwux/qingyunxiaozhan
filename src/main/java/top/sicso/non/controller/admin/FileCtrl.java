package top.sicso.non.controller.admin;//package top.sicso.non.controller.admin;
//
//import me.qyxz.blog.domain.Info;
//import me.qyxz.blog.domain.UploadPic;
//import me.qyxz.blog.service.inter.FileUploadSer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//public class FileCtrl {
//
//    private FileUploadSer uploadSer;
//
//    @Autowired
//    public FileCtrl(FileUploadSer uploadSer) {
//        this.uploadSer = uploadSer;
//    }
//
//    @PostMapping("/admin/file/uplPic.action")
//    @ResponseBody
//    public UploadPic uploadPic(HttpServletRequest request){
//            return uploadSer.uploadPic(request);
//    }
//
//    @PostMapping("/admin/file/uplAva.action")
//    public String uploadAva(HttpServletRequest request, Model model){
//        Info info=uploadSer.updateAvatar(request);
//        model.addAttribute("info",info);
//        return "admin/info";
//    }
//}
