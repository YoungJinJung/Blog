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

    @Transactional(readOnly = true)
    public User findUser(String username) {
        User user = userRepository.findByUsername(username).orElseGet(() -> {
            return new User();
        });
        return user;
    }

    @Transactional
    public void signUp(User user) {
        String rawPassword = user.getPassword();
        String encodePassword = encode.encode(rawPassword);
        user.setPassword(encodePassword);
        user.setRole(UserRole.USER);
        userRepository.save(user);
    }

    @Transactional
    public void updateUserInfo(User user) {
        int id = user.getId();
        User currUser = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException(("Failed to load User Info : cannot find User id"));
        });

        //Validate
        if (currUser.getLoginType().equals("GENERAL")) {
            String rawPassword = user.getPassword();
            String encodePassword = encode.encode(rawPassword);
            currUser.setPassword(encodePassword);
            currUser.setEmail(user.getEmail());
        }
    }
}

    /*@Transactional(readOnly = true)//정합성 유지
    public User signIn(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }*/
