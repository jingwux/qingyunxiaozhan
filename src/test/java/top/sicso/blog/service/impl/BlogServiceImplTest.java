package top.sicso.blog.service.impl;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
        blogCondition.setPageIndex(1);
        blogCondition.setPageSize(10);
        Page<BlogVO> blog = blogService.getBlogByCondition(blogCondition);
       /* System.out.println("总数：" + blog.getTotalElements());
        System.out.println("总页数：" + blog.getTotalPages());
        System.out.println("当前页：" + blog.getNumber());
        System.out.println("元素个数：" + blog.getNumberOfElements());
        System.out.println("页大小：" + blog.getSize());
        System.out.println("有下一页：" + blog.hasNext());
        System.out.println("有数据：" + blog.hasContent());
        System.out.println("有前一页" + blog.hasPrevious());
        System.out.println("是第一页：" + blog.isFirst());
        System.out.println("是最后一页：" + blog.isLast());*/


        assertNotNull(blog);
        blog.getContent().forEach(System.out::println);
    }


}