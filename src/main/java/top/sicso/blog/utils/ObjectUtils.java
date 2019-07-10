package top.sicso.blog.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


public class ObjectUtils {


    public static boolean isBlank(Object obj) {
        if (obj == null) {
            return true;
        }
        if ((obj instanceof List)) {
            return ((List) obj).size() == 0;
        }
        if ((obj instanceof String)) {
            return ((String) obj).trim().equals("");
        }


        return true;
    }

    public static boolean isNotBlank(Object obj){
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object o = null;
            try {
                o = field.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            Type type = field.getGenericType();
            if (o != null && !"".equals(o)){
                return true;
            }
        }
        return false;
    }

}
