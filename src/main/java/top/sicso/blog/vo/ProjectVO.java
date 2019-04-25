package top.sicso.blog.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectVO {

    private int id;//id

    private String name;//项目名称

    private String url;//项目url地址，例如https://github.com/yuanqingx/qingyunxiaozhan

    private String tech;//项目所用技术

    private String description;//项目描述

    private Date date;//项目创建时间

}
