package com.project.blog.service;

import com.project.blog.model.Board;
import com.project.blog.model.User;
import com.project.blog.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    public Page<Board> getPotList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Board getPost(int id) {
        return boardRepository.findById(id).orElseThrow(()->{return new IllegalArgumentException("Failed to load post : cannot find post id");});
    }
}