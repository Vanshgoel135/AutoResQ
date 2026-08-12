package com.autoresq.user.service.impl;

import com.autoresq.user.dto.RegisterRequest;
import org.springframework.stereotype.Service;
import com.autoresq.user.repository.UserRepository;
import com.autoresq.user.service.UserService;
import com.autoresq.user.entity.User;
@Service
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
   public void register(RegisterRequest request){
        User user=new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(request.getPassword());
        user.setRole("USER");

        userRepository.save(user);
    }
}
