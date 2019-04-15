package top.sicso.blog.pojo;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

/**
 * 博客页面的存储，包括id,日期，标题和博客页面
 */
@Data
@Entity
@Table(name = "tb_blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;//id

    private Date date;//博客创建日期

    private String title;//博客标题，不可为空

    private String article;//博客内容的html文本

    private String tags;//标签，不同标签以,隔开

    private String md;//博客内容的markdown文本

    @Transient
    private String monthDay;//形如"Oct 04",为了方便archives页面显示，并不对应数据库的任何一列

}

