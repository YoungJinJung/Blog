package com.project.blog.controller;

import com.project.blog.config.auth.PrincipalDetail;
import com.project.blog.dto.ResponseDto;
import com.project.blog.model.Board;
import com.project.blog.model.User;
import com.project.blog.model.UserRole;
import com.project.blog.service.BoardService;
import com.project.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApiController {
    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        boardService.writePost(board, principalDetail.getUser());
        return new ResponseDto<>(HttpStatus.OK, 1);
    }
}
