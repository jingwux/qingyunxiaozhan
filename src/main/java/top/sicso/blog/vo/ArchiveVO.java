package top.sicso.blog.vo;

import lombok.*;
import top.sicso.blog.pojo.Blog;

import java.util.List;


/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


@Data
public class ArchiveVO {

    private String year;//年份

    private String month;//年份

    private List<Blog> list;//此年份的博客列表

}
