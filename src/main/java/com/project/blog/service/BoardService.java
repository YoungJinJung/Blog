package com.project.blog.service;

import com.project.blog.dto.ReplySaveRequestDto;
import com.project.blog.model.Board;
import com.project.blog.model.Reply;
import com.project.blog.model.User;
import com.project.blog.repository.BoardRepository;
import com.project.blog.repository.ReplyRepository;
import com.project.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private ReplyRepository replyRepository;

    @Transactional
    public void writePost(Board board, User user) {
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    public Page<Board> getPotList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board getPost(int id) {
        return boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to load post : cannot find post id"));
    }

    @Transactional
    public void deletePost(int id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public void updatePost(int id, Board requestBoard) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to load post : cannot find post id"));//영속화
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        //이떄 더티체킹 - 자동 업데이트
    }

    @Transactional
    public void writeReply(ReplySaveRequestDto replyDto) {
        /*Board board = boardRepository.findById(replyDto.getBoardId()).orElseThrow(() -> {
            return new IllegalArgumentException("Failed to write reply : cannot find post id");
        });//영속화

        User user = userRepository.findById(replyDto.getUserId()).orElseThrow(() -> {
            return new IllegalArgumentException("Failed to write reply : cannot find post id");
        });

        Reply reply = Reply.builder()
                .user(user)
                .board(board)
                .content(replyDto.getContent()).build();*/

        replyRepository.customSave(replyDto.getUserId(), replyDto.getBoardId(), replyDto.getContent());
    }

    @Transactional
    public void deleteReply(int replyId) {
        replyRepository.deleteById(replyId);
    }
}