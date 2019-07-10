package top.sicso.blog.pojo;


import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


@Entity
@Data
@Table(name = "tb_tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String tagName;

    private Integer blogId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(tagName.toUpperCase(), tag.tagName.toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagName);
    }
}
