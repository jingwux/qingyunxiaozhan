package top.sicso.blog.config;


import org.springframework.core.convert.converter.Converter;
import top.sicso.blog.utils.TimeUtils;

import java.time.LocalDate;
import java.util.Date;

public class Date2LocalDateConverter implements Converter<Date, LocalDate> {

    @Override
    public LocalDate convert(Date source) {
        return TimeUtils.date2LocalDate(source);
    }
}
