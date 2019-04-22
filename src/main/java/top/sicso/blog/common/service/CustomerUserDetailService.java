package top.sicso.blog.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import top.sicso.blog.pojo.Admin;
import top.sicso.blog.admin.service.AdminService;

@Service
public class CustomerUserDetailService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminService.getByName(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(admin.getPassword().trim());
        return new User(admin.getUsername(), encode, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
    }
}
