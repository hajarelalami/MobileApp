package com.blog.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UsernameAlreadyExists extends AuthenticationException {
    public UsernameAlreadyExists() {
        super("Username already exist");
    }
}
