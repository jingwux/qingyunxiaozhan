package top.sicso.blog.service;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import top.sicso.blog.pojo.Blog;
import top.sicso.blog.pojo.Tag;
import top.sicso.blog.vo.ArchiveVO;
import top.sicso.blog.vo.BlogCondition;
import top.sicso.blog.vo.BlogVO;

import java.util.List;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


public interface BlogService{

    // Blog
    BlogVO getBlogByBlogId(Integer blogId);

    PageInfo<ArchiveVO> getArchivesOrderByMonth(int pageIndex);

    PageInfo<BlogVO> getBlogByTagName(String tagName);

    Page<BlogVO> getBlogByCondition(BlogCondition blogCondition);

    Blog addBlog(Blog blog);

    Blog updateBlog(Blog blog);

    void deleteBlog(Integer blogId);


    // Tag

    Tag getTagByTagName(String tagName);

    List<Tag> getAllTags();

    List<Tag> getTagsByBlogId(Integer blogId);

    void deleteTagsByBlogId(Integer blogId);

}
