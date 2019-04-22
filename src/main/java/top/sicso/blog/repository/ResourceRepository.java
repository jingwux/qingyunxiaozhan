package top.sicso.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.sicso.blog.pojo.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

}
