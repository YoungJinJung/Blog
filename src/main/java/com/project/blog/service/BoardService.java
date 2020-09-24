package com.project.blog.service;

import com.project.blog.config.auth.PrincipalDetail;
import com.project.blog.model.Board;
import com.project.blog.model.User;
import com.project.blog.model.UserRole;
import com.project.blog.repository.BoardRepository;
import com.project.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void writePost(Board board, User user) {
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    public List<Board> getPotList() {
        return boardRepository.findAll();
    }
}