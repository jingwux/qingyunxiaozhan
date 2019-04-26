package top.sicso.blog.vo;

import lombok.Data;
import lombok.ToString;
import top.sicso.blog.pojo.Blog;

import java.util.Date;

@Data
@ToString
public class BlogVO {

    private Integer id;//id

    private Date date;//博客创建日期

    private String title;//博客标题，不可为空

    private String article;//博客内容的html文本

    private String tags;//标签，不同标签以,隔开

    private String md;//博客内容的markdown文本

    private String monthDay;//形如"Oct 04",为了方便archives页面显示，并不对应数据库的任何一列


    private Blog prevBlog;

    private Blog nextBlog;


}
