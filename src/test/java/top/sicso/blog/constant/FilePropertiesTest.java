package top.sicso.blog.constant;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.sicso.blog.InitTest;

import static org.junit.Assert.*;

public class FilePropertiesTest extends InitTest {

    @Autowired
    private FileProperties fileProperties;

    @Test
    public void testGetFileProperties(){
        Assert.assertNotNull(fileProperties);

        Assert.assertNotNull(fileProperties.getBase());
        System.out.println(fileProperties.getBase());

    }


}