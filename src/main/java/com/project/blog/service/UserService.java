package com.project.blog.service;

import com.project.blog.model.User;
import com.project.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void signUp(User user) {
        userRepository.save(user);
    }

    /*@Transactional(readOnly = true)//정합성 유지
    public User signIn(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }*/
}
