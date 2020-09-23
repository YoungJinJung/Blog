package com.project.blog.service;

import com.project.blog.model.User;
import com.project.blog.model.UserRole;
import com.project.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encode;

    @Transactional
    public void signUp(User user) {
        String rawPassword = user.getPassword();
        String encodePassword = encode.encode(rawPassword);
        user.setPassword(encodePassword);
        user.setRole(UserRole.USER);
        userRepository.save(user);
    }
}

    /*@Transactional(readOnly = true)//정합성 유지
    public User signIn(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }*/
