package top.sicso.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sicso.blog.pojo.Admin;
import top.sicso.blog.repository.AdminRepository;
import top.sicso.blog.service.AdminService;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public boolean add(Admin admin) {
        return adminRepository.save(admin) != null;
    }

    @Override
    public boolean login(String username, String password) {
        return adminRepository.findUserByUsernameAndPassword(username, password) != null;
    }
}
