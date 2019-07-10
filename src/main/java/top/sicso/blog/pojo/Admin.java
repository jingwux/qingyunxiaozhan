package top.sicso.blog.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


@Data
@Entity
@Table(name = "tb_admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String md;

    private String resume;

    private String avatar;

    private String info;

    @Transient
    private List<Role> roles;

}
