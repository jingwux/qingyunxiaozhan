package top.sicso.blog.utils;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TimeUtilsTest {

    @Test
    public void getCurrentDate() {
        TimeUtils.getCurrentDate();

    }

    @Test
    public void getCurrentDateTime() {
       TimeUtils.getCurrentDateTime();

    }
    @Test
    public void stringDate2LocalDate() {
        TimeUtils.stringDate2LocalDate("2018-09-10");

    }
}