package com.example.response.controller;


import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
    } //Controller 라는 annotation은 String을 리턴하면 리소스를 찾게됨

    //ResponseEntity

    @ResponseBody //Json으로 객체 자체를 내려줌
    @GetMapping("/user")
    public User user(){
        var user = new User();
        user.setName("steve");
        user.setAddress("패스트캠퍼스");
        return user;
    }
}
