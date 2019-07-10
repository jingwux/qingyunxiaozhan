package top.sicso.blog.pojo;

import lombok.*;

import javax.persistence.Table;


/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "tb_user")
public class Info implements java.io.Serializable {

    private String username;//用户名
    private String password;//md5加密后的密码
    private String email;//邮箱,默认为#
    private String github;//github地址，默认为#
    private String md;//简历的markdown文本，为了admin管理时能够回显
    private String resume;//简历的html文本
    private String avatar;//头像地址
}
