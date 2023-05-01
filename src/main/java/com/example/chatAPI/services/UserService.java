package com.example.chatAPI.services;

import com.example.chatAPI.models.User;
import com.example.chatAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username) {
        User user = new User();
        user.setUsername(username);
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Long deleteUser(Long id) {
        userRepository.deleteById(id);
        return id;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}



