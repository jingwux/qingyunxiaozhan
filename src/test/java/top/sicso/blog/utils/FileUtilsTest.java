package top.sicso.blog.utils;

import org.junit.Test;
import top.sicso.blog.InitTest;
import top.sicso.blog.constant.FileHelper;

import java.io.IOException;

import static org.junit.Assert.*;

public class FileUtilsTest extends InitTest {

    @Test
    public void uploadPicture() {

        try {
            String s = FileUtils.uploadPicture(FileHelper.PICTURE, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getSuffix() {

        String s = FileUtils.getSuffix("register.css");

    }
}