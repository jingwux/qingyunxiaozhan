package top.sicso.blog.admin.service;

import top.sicso.blog.pojo.Admin;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


public interface AdminService {

    boolean add(Admin admin);

    boolean login(String username,String password);

    Admin getByName(String adminName);

    Admin getAdmin();

}
