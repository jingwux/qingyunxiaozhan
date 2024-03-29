package top.sicso.blog.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.sicso.blog.common.BaseCondition;

import java.sql.Date;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


@Data
@EqualsAndHashCode(callSuper = false)
public class BlogCondition extends BaseCondition {

    private Integer id;//id

    private Date date;//博客创建日期

    private String title;//博客标题，不可为空

    private String tags;//标签，不同标签以,隔开



}
