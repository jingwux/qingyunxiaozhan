package top.sicso.blog.service;

import com.github.pagehelper.PageInfo;
import top.sicso.blog.common.service.BaseService;
import top.sicso.blog.common.service.impl.BaseServiceImpl;
import top.sicso.blog.pojo.Blog;
import top.sicso.blog.pojo.Tag;
import top.sicso.blog.vo.ArchiveVO;
import top.sicso.blog.vo.BlogVO;

import java.util.List;

public interface BlogService{

    // Blog
    BlogVO getBlogByBlogId(Integer blogId);

    PageInfo<ArchiveVO> getArchivesOrderByMonth(int pageIndex);

    PageInfo<BlogVO> getBlogByTagName(String tagName);

    Blog addBlog(Blog blog);


    // Tag

    Tag getTagByTagName(String tagName);

    List<Tag> getAllTags();

    List<Tag> getTagsByBlogId(Integer blogId);

}
