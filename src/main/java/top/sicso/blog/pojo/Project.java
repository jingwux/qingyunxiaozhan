package top.sicso.blog.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/16.
 */

@Data
@Entity
@Table(name = "tb_project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;//id

    private String name;//项目名称

    private String url;//项目url地址，例如https://github.com/jcalaz/jcalaBlog

    private String tech;//项目所用技术

    private String description;//项目描述

    @Temporal(TemporalType.DATE)
    private Date date;//项目创建时间
}
