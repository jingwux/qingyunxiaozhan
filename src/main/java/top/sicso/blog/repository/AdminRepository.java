package top.sicso.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.sicso.blog.pojo.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findUserByUsernameAndPassword(String username, String password);

}
