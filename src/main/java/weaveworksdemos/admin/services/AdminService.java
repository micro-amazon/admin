package weaveworksdemos.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weaveworksdemos.admin.repositories.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public boolean isLoginSuccess(String username, String password) {
        // temporary workaround
        return username.equals("admin") && password.equals("password");
//        return adminRepository.existsByUsernameAndPassword(username, password);
    }
}
