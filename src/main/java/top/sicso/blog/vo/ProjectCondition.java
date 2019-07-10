package top.sicso.blog.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.sicso.blog.common.BaseCondition;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectCondition extends BaseCondition {

    private Integer id;//id

    private String name;//项目名称

    private String tech;//项目所用技术

}
