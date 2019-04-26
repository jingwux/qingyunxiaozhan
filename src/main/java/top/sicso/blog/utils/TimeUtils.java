package top.sicso.blog.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeUtils {

    //默认使用系统当前时区
    private static final ZoneId ZONE = ZoneId.systemDefault();

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private static final String DATE_FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";

    private static final String TIME_NOFUII_FORMAT = "yyyyMMddHHmmss";

    private static final String REGEX = "\\:|\\-|\\s";

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前日期
     *
     * @return
     */
    public static Date getCurrentDate() {
        return Date.from(LocalDate.now().atStartOfDay().atZone(ZONE).toInstant());
    }

    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static Date getCurrentDateTime() {
        return Date.from(LocalDateTime.now().atZone(ZONE).toInstant());
    }


    public static LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZONE);
        return localDateTime.toLocalDate();
    }


    public static LocalDate stringDate2LocalDate(String date){
        return LocalDate.parse(date,DateTimeFormatter.ISO_DATE);
    }

    /**
     * 将日期对象格式化为 yyyy-MM-dd
     *
     * @return
     */
    public static Date formatDate(Date date) {
        return null;
    }


}
