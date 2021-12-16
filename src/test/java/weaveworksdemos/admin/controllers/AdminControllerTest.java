package weaveworksdemos.admin.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import weaveworksdemos.admin.services.AdminService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdminController.class)
class AdminControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AdminService adminService;

    @Test
    @DisplayName("login 성공")
    void loginSuccess() throws  Exception {
        //given
        String username = "admin";
        String password = "password";

        //when
        when(adminService.isLoginSuccess(username, password)).thenReturn(true);

        //then
        mockMvc.perform(post("/login")
                        .param("username", username)
                        .param("password", password))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("login 실패")
    void loginFail() throws  Exception {
        //given
        String username = "user";
        String password = "password";

        //when
        when(adminService.isLoginSuccess(username, password)).thenReturn(false);

        //then
        mockMvc.perform(post("/login")
                        .param("username", username)
                        .param("password", password))
                .andExpect(status().is4xxClientError())
                .andDo(print());
    }

    @Test
    @DisplayName("관리자 계정 정상 등록")
    void registerSuccess() throws Exception {
        //given
        Long id = 1L;
        String username = "newadmin";
        String password = "password";

        //when
        when(adminService.saveAdmin(username, password)).thenReturn(1L);

        mockMvc.perform(post("/register")
                .param("username", username)
                .param("password", password))
                .andExpect(content().string("1"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}