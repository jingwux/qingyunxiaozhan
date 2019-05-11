package top.sicso.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.sicso.blog.pojo.Tag;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag,Integer> {

    Tag findByTagName(String tagName);

    List<Tag> findByBlogId(Integer vid);

    void deleteByBlogId(Integer blogId);
}
