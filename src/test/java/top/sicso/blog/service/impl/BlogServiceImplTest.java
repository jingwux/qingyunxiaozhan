package top.sicso.blog.service.impl;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.sicso.blog.InitTest;
import top.sicso.blog.pojo.Tag;
import top.sicso.blog.service.BlogService;
import top.sicso.blog.vo.BlogCondition;
import top.sicso.blog.vo.BlogVO;

import java.util.List;

import static org.junit.Assert.*;

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
        BlogCondition blogCondition = new BlogCondition();
        blogCondition.setPageIndex(0);
        blogCondition.setPageSize(5);
        PageInfo<BlogVO> blog = blogService.getBlogByCondition(blogCondition);
        assertNotNull(blog);
        blog.getList().forEach(System.out::println);
    }


}