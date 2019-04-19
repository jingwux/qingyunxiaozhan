package top.sicso.blog.normal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import top.sicso.blog.InitTest;
import top.sicso.blog.pojo.Admin;
import top.sicso.blog.repository.AdminRepository;

public class BCryptTest extends InitTest {

    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void testAddBCryptPassword(){
        Admin admin = adminRepository.findByUsername("myyl");
        // old :81dc9bdb52d04dc20036dbd8313ed055
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(admin.getPassword().trim());
        admin.setPassword(encode);
        adminRepository.saveAndFlush(admin);
    }

}
