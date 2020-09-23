package com.project.blog.controller;

import com.project.blog.config.auth.PrincipalDetail;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    //@AuthenticationPrincipal PrincipalDetail principalDetail
    @GetMapping({"", "/"})
    public String index() {
        //WEB-INF/view/index.jsp
        return "index";
    }
}
