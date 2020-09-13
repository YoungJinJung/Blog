package com.project.blog.controller;

import org.hibernate.annotations.Cache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    @GetMapping({"", "/"})
    public String index() {
        //WEB-INF/view/index.jsp
        return "index";
    }
}
