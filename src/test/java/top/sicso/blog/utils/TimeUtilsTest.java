package top.sicso.blog.utils;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TimeUtilsTest {

    @Test
    public void getCurrentDate() {
        Date currentDate = TimeUtils.getCurrentDate();

    }

    @Test
    public void getCurrentDateTime() {
        Date currentDate = TimeUtils.getCurrentDateTime();

    }
}