package top.sicso.non.service;//package me.sicso.non.service;
//
//import Info;
//import me.sicso.non.mapping.InfoMapper;
//import InfoSer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Isolation;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//@Service//
//public class InfoSerImpl implements InfoSer {
//    private static final int MODIFY_PASS_SUCCESS = 0;//修改密码成功
//    private static final int PASS_ERROR = 1;//密码错误
//    private static final int SYSTEM_ERROR = 2;//系统错误
//    private static final Logger LOGGER = LoggerFactory.getLogger(InfoSerImpl.class);
//    @Autowired
//    private InfoMapper infoMapper;
//
//    @Override
//    @Cacheable(value = "profileOfInfo", key = "1")
//    public Info getInfo() {
//        return infoMapper.select();
//    }
//
//    @Override
//    public boolean login(Info user) {
//        int num = 0;
//        try {
//            num = infoMapper.selectByPw(user.getUsername(), user.getPassword());
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage());
//        }
//        return num > 0;
//    }
//
//    @Override
//    public boolean checkPass(String oldPass) {
//        int num = infoMapper.selectByOldPass(oldPass);
//        return num > 0;
//    }
//
//    @Override
//    @CacheEvict(value = "profileOfInfo", key = "1")
//    public boolean updateInfo(Info info) {
//        boolean result = true;
//        try {
//            infoMapper.update(info);
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage());
//            result = false;
//        }
//        return result;
//    }
//
//    @Override
//    @Transactional(isolation = Isolation.READ_COMMITTED)
//    public int modifyPw(String oldPass, String newPass) {
//        int result;
//        if (checkPass(oldPass)) {
//            try {
//                infoMapper.updataPass(newPass);
//                result = MODIFY_PASS_SUCCESS;
//            } catch (Exception e) {
//                LOGGER.error(e.getMessage());
//                result = SYSTEM_ERROR;
//            }
//        } else {
//            result = PASS_ERROR;
//        }
//        return result;
//    }
//
//    @Override
//    public void addSession(HttpServletRequest request, Info info) {
//        HttpSession session = request.getSession(true);
//        session.setAttribute("cur_user", info);
//        session.setMaxInactiveInterval(600);
//    }
//
//    @Override
//    public void destroySession(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        session.removeAttribute("cur_user");
//    }
//
//    @Override
//    public String getResumeMd() {
//        String md = "";
//        try {
//            md = infoMapper.selectMd();
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage());
//        }
//        return md;
//    }
//
//    @Override
//    @CacheEvict(value = "resumeView", key = "1")
//    public boolean updateResume(Info info) {
//        boolean result = true;
//        try {
//            infoMapper.updateResume(info);
//        } catch (Exception e) {
//            result = false;
//            LOGGER.error(e.getMessage());
//        }
//        return result;
//    }
//
//    @Override
//    @Cacheable(value = "resumeView", key = "1")
//    public String getResumeView() {
//        return infoMapper.selectResume();
//    }
//
//    @Override
//    @CacheEvict(value = "profileOfInfo", key = "1")
//    public void updateAvatar(String avatar) {
//        infoMapper.updateAvater(avatar);
//    }
//}
