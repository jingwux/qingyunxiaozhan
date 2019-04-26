package top.sicso.blog.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.sicso.blog.common.BaseCondition;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectCondition extends BaseCondition {

    private Integer id;//id

    private String name;//项目名称

    private String tech;//项目所用技术

}
