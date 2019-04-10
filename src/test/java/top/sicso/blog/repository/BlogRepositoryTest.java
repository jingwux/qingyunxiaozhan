package top.sicso.blog.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.sicso.blog.InitTest;
import top.sicso.blog.pojo.Blog;

import static org.junit.Assert.*;

public class BlogRepositoryTest extends InitTest {

    @Autowired
    private BlogRepository blogRepository;

    @Test
    public void findPrevBlog(){
        Blog nextBlog = blogRepository.findPrevBlog(34);


    }

    @Test
    public void findNextBlog(){
        Blog nextBlog = blogRepository.findNextBlog(34);


    }

}