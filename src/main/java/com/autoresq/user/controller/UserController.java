package com.autoresq.user.controller;

import com.autoresq.user.dto.RegisterRequest;
import com.autoresq.user.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/users")
public class UserController {
private final UserService userService;
public UserController(UserService userService){
    this.userService=userService;
}
@PostMapping("/register")
    public String register(@RequestBody RegisterRequest request){
    userService.register(request);
    return "User Registered Successfully";
}
}
