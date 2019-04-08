package top.sicso.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.sicso.blog.pojo.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
