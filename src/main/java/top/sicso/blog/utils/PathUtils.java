package top.sicso.blog.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


@Slf4j
public class PathUtils {

    public static String getRootServerPath(HttpServletRequest request) {
        try {
           return new URL(request.getScheme(), request.getServerName(), request.getServerPort(), request.getContextPath()).toString();
        } catch (MalformedURLException e) {
            log.warn(e.getLocalizedMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}
