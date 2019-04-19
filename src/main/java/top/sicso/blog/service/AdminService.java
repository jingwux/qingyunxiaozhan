package top.sicso.blog.service;

import top.sicso.blog.pojo.Admin;

public interface AdminService {

    boolean add(Admin admin);

    boolean login(String username,String password);

    Admin getByName(String adminName);

}
