package top.sicso.blog.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.sicso.blog.Application;
import top.sicso.blog.pojo.Tag;
import top.sicso.blog.service.BlogService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BlogServiceImplTest {

    @Autowired
    private BlogService blogService;


    @Test
    public void getArchivesOrderByMonth() {
        blogService.getArchivesOrderByMonth(0);

    }

    @Test
    public void getBlogByTagName(){
        blogService.getBlogByTagName("1");
    }

    @Test
    public void getAllTags(){
        List<Tag> allTags = blogService.getAllTags();
        allTags.forEach(System.out::println);
    }
}