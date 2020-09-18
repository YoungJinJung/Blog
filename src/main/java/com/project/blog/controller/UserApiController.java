package com.project.blog.controller;

import com.project.blog.dto.ResponseDto;
import com.project.blog.model.User;
import com.project.blog.model.UserRole;
import com.project.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {
    @Autowired
    private UserService userService;

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("UserApiController: Save Called");
        user.setRole(UserRole.USER);
        userService.signUp(user);
        return new ResponseDto<>(HttpStatus.OK, 1);
    }
}
