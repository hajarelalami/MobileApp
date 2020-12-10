package com.blog.blog.services;

import com.blog.blog.exception.UsernameAlreadyExists;
import com.blog.blog.data.entities.User;
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

    public User registerNewUserAccount(User accountDto) {
        if (userRepository.findUserWithName(accountDto.getUsername()).isPresent()) {
            throw new UsernameAlreadyExists();
        }
        accountDto.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        return userRepository.save(accountDto);
    }
}
