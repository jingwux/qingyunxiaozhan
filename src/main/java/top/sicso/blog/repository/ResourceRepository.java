package top.sicso.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.sicso.blog.pojo.Resource;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

}
