package top.sicso.blog.pojo;

import lombok.Data;
import org.springframework.security.core.Transient;

import javax.persistence.*;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


@Data
@Entity
@Table(name = "tb_resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rname")
    private String resourceName;

    private String description;

    private String url;

    @Column(name = "type")
    private Integer resourceType;

    private String filename;

    private String filepath;

    /**
     * 0 有效 ，1 无效
     */
    private Integer status;


}
