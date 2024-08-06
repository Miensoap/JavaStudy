package com.example.inflearn_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }

    // 요청 -> 컨트롤러 -> 없으면 static 파일
}
