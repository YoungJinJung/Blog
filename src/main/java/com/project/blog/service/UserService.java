package com.project.blog.service;

import com.project.blog.model.User;
import com.project.blog.model.UserRole;
import com.project.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.MimeMessage;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encode;
    @Autowired
    JavaMailSender mailSender;

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

    @Transactional
    public int sendMail(String mailAddress) {
        int certificatedNum = (int)((Math.random()* (99999 - 10000 + 1)) + 10000);

        String from = "tlrpsh21@naver.com";//보내는 이 메일주소
        String to = mailAddress;
        String title = "회원가입시 필요한 인증번호 입니다.";
        String content = "[인증번호] "+ certificatedNum +" 입니다. <br/> 인증번호 확인란에 기입해주십시오.";
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");

            mailHelper.setFrom(from);
            mailHelper.setTo(to);
            mailHelper.setSubject(title);
            mailHelper.setText(content, true);

            mailSender.send(mail);
        } catch(Exception e) {
            return -1;
        }
        return certificatedNum;
    }
}

    /*@Transactional(readOnly = true)//정합성 유지
    public User signIn(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }*/
