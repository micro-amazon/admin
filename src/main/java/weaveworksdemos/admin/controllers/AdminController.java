package weaveworksdemos.admin.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weaveworksdemos.admin.services.AdminService;

@Slf4j
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity login(String username, String password) {
        log.info(username);
        log.info(password);

        Boolean isLoginSuccess = adminService.isLoginSuccess(username, password);
        if(isLoginSuccess) {
            log.info("login success");
            return new ResponseEntity(HttpStatus.OK);
        } else {
            log.info("login fail");
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(String username, String password) {
        String adminId = adminService.saveAdmin(username, password);
        return new ResponseEntity(adminId, HttpStatus.OK);
    }

}
