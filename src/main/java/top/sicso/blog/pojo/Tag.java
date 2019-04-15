package top.sicso.blog.pojo;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String tagName;

    private Integer blogId;

}
