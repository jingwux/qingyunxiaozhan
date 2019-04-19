package top.sicso.blog.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.sicso.blog.pojo.Admin;
import top.sicso.blog.service.AdminService;

@Service
public class CustomerUserDetailService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminService.getByName(username);
        return new User(admin.getUsername(), admin.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN"));
    }
}
