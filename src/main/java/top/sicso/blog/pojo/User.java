package top.sicso.blog.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String Username;

    private String password;

    private String tel;

    private String email;

    private String md;

    private String resume;

    private String avatar;

    private String info;

}
