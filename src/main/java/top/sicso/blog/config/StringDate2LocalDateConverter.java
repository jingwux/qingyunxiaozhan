package top.sicso.blog.config;

import org.springframework.core.convert.converter.Converter;
import top.sicso.blog.utils.TimeUtils;

import java.time.LocalDate;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


public class StringDate2LocalDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String source) {
        return TimeUtils.stringDate2LocalDate(source);
    }

}
