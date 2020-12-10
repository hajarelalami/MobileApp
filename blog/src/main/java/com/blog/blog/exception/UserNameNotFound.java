package com.blog.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UserNameNotFound extends AuthenticationException {
    public UserNameNotFound(String message) {
        super(message);
    }
}
