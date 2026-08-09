package com.autoresq.user.service;

import com.autoresq.user.dto.RegisterRequest;
import com.autoresq.user.entity.User;

public interface UserService {

    User registerUser(RegisterRequest request);

}