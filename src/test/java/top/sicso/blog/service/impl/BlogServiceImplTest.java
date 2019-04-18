package top.sicso.blog.service.impl;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.sicso.blog.Application;
import top.sicso.blog.InitTest;
import top.sicso.blog.pojo.Tag;
import top.sicso.blog.service.BlogService;
import top.sicso.blog.vo.BlogCondtion;
import top.sicso.blog.vo.BlogVO;

import java.util.List;

public class BlogServiceImplTest extends InitTest {

    @Autowired
    private BlogService blogService;


    @Test
    public void getBlogByTagName(){
        blogService.getBlogByTagName("1");
    }

    @Test
    public void getArchivesOrderByMonth() {
        blogService.getArchivesOrderByMonth(0);

    }

    @Test
    public void getAllTags(){
        List<Tag> allTags = blogService.getAllTags();
        allTags.forEach(System.out::println);
    }


    @Test
    public void getBlogByBlogId(){
        BlogVO blog = blogService.getBlogByBlogId(34);
    }

    @Test
    public void getBlogByCondition(){
        BlogCondtion blogCondtion = new BlogCondtion();
        blogCondtion.setPageIndex(1);
        blogCondtion.setPageSize(5);
        blogCondtion.setTags("java");
        PageInfo<BlogVO> blog = blogService.getBlogByCondition(blogCondtion);
        blog.getList().forEach(System.out::println);
    }


}