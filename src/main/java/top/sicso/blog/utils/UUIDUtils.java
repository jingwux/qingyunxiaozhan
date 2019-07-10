package top.sicso.blog.utils;

import java.util.UUID;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


public class UUIDUtils {

    public static String createUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}
