package com.autoresq.user.service;

import com.autoresq.user.dto.RegisterRequest;
import com.autoresq.user.dto.LoginRequest;

public interface UserService {

    void register(RegisterRequest request);

    String login(LoginRequest request);
}