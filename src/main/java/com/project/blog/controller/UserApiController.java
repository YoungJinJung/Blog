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

@RestController
public class UserApiController {
    @Autowired
    private UserService service;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("UserApiController: Called");
        user.setRole(UserRole.USER);
        service.signUp(user);
        return new ResponseDto<>(HttpStatus.OK, 1);
    }
}
