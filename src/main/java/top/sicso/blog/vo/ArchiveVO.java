package top.sicso.blog.vo;

import lombok.*;
import top.sicso.blog.pojo.Blog;

import java.util.List;

/**
 * 前端页面archives显示的博客列表对应的实体
 */
@Data
public class ArchiveVO {

    private String year;//年份

    private String month;//年份

    private List<Blog> list;//此年份的博客列表

}
