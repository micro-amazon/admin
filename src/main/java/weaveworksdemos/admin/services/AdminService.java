package weaveworksdemos.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weaveworksdemos.admin.repositories.AdminRepository;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public boolean isLoginSuccess(String username, String password) {
        return adminRepository.existsByUsernameAndPassword(username, password);
    }
}
