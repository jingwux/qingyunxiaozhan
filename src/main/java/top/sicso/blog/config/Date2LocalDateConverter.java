package top.sicso.blog.config;


import org.springframework.core.convert.converter.Converter;
import top.sicso.blog.utils.TimeUtils;

import java.time.LocalDate;
import java.util.Date;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


public class Date2LocalDateConverter implements Converter<Date, LocalDate> {

    @Override
    public LocalDate convert(Date source) {
        return TimeUtils.date2LocalDate(source);
    }
}
