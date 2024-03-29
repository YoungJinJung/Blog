package com.project.blog.controller;

import com.project.blog.config.auth.PrincipalDetail;
import com.project.blog.config.auth.PrincipalDetailService;
import com.project.blog.dto.ResponseDto;
import com.project.blog.model.LoginType;
import com.project.blog.model.User;
import com.project.blog.model.UserRole;
import com.project.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {
    @Autowired
    private UserService userService;
    @Autowired
    private PrincipalDetailService principalDetailService;


    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("UserApiController: Save Called");
        user.setRole(UserRole.USER);
        user.setLoginType(LoginType.GENERAL);
        userService.signUp(user);
        return new ResponseDto<>(HttpStatus.OK, 1);
    }

    @PutMapping("/user")
    public ResponseDto<Integer> update(@RequestBody User user, HttpSession session) {
        userService.updateUserInfo(user);
        UserDetails currUserDetails = principalDetailService.loadUserByUsername(user.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(currUserDetails, currUserDetails.getPassword(), currUserDetails.getAuthorities());
        SecurityContext securityContext = SecurityContextHolder.getContext();
       // Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(currUserDetails, currUserDetails.getPassword(), currUserDetails.getAuthorities()));
       // SecurityContextHolder.getContext().setAuthentication(authentication);
        securityContext.setAuthentication(authentication);
        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
        return new ResponseDto<>(HttpStatus.OK, 1);
    }

    @PostMapping("/auth/checkUserName/{userName}")
    public ResponseDto<Integer> checkUserName(@PathVariable String userName) {
        ResponseDto<Integer> response = new ResponseDto<>(HttpStatus.OK, 0);
        System.out.println("UserApiController: checkUserName Called");
        User selectedUser = userService.findUser(userName);
        if (selectedUser.getUsername() != null) {
            response =  new ResponseDto<>(HttpStatus.OK, 1);
        }
        return response;
    }

    @GetMapping("/auth/checkMail/{mailAddress}")
    public ResponseDto<Integer> checkMail(@PathVariable String mailAddress) {
        System.out.println("UserApiController: checkMail Called");
        int certificatedNum = userService.sendMail(mailAddress);
        return new ResponseDto<>(HttpStatus.OK, certificatedNum);
    }
}
