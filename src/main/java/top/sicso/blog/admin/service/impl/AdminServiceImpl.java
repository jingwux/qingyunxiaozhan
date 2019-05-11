package top.sicso.blog.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sicso.blog.admin.service.AdminService;
import top.sicso.blog.pojo.Admin;
import top.sicso.blog.repository.AdminRepository;

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

    @Override
    public Admin getByName(String adminName) {
        return adminRepository.findByUsername(adminName);
    }

    @Override
    public Admin getAdmin() {
        return adminRepository.findAll().get(0);
    }
}
