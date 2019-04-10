package top.sicso.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import top.sicso.blog.pojo.Blog;

import java.util.List;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "SELECT DATE_FORMAT(date,'%Y-%m') as date  from tb_blog GROUP BY date ORDER BY date DESC LIMIT :size, 12 ", nativeQuery = true)
    List<String> findGroupByDate(@Param("size") int size);

    @Query(value = "SELECT * from tb_blog WHERE DATE_FORMAT(date,'%Y-%m') = :date", nativeQuery = true)
    List<Blog> findBlogByDate(@Param("date") String date);

    List<Blog> findBlogByTagsContains(String tagName);

    @Query(value = "select *  from tb_blog where vid < :blogId order by vid desc limit 1", nativeQuery = true)
    Blog findPrevBlog(@Param("blogId") Integer blogId);

    @Query(value = "select *  from tb_blog where vid > :blogId limit 1", nativeQuery = true)
    Blog findNextBlog(@Param("blogId") Integer blogId);

}
