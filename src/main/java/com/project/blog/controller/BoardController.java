package com.project.blog.controller;

import com.project.blog.config.auth.PrincipalDetail;
import com.project.blog.service.BoardService;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    //@AuthenticationPrincipal PrincipalDetail principalDetail
    @GetMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("boards", boardService.getPotList());
        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
}
