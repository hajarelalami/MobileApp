package com.blog.blog.services;

import com.blog.blog.data.entities.UserEntity;
import com.blog.blog.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public UserEntity registerNewUserAccount(UserEntity accountDto) {
        if (userRepository.findUserWithName(accountDto.getUsername()).isPresent()) {
            throw new RuntimeException();
            // Add Exception
        }
        accountDto.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        return userRepository.save(accountDto);
    }
}
