package top.sicso.blog.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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

    @Temporal(TemporalType.DATE)
    private Date date;//博客创建日期

    private String title;//博客标题，不可为空

    private String tags;//标签，不同标签以,隔开

    /**
     * 0 原创 ，1转载
     */
    private Integer original;

    @Column(name = "o_url")
    private String oUrl;

    private String article;//博客内容的html文本

    private String md;//博客内容的markdown文本

    @Transient
    private String monthDay;//形如"Oct 04",为了方便archives页面显示，并不对应数据库的任何一列

}

