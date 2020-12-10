package com.blog.blog.Controllers;


import com.blog.blog.authentification.CustomUserDetailsService;
import com.blog.blog.authentification.JwtTokenProvider;
import com.blog.blog.data.entities.JwtRequest;
import com.blog.blog.data.entities.JwtResponse;
import com.blog.blog.data.entities.User;
import com.blog.blog.models.UserInfo;
import com.blog.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        Authentication authentication = authenticate(authenticationRequest.getUsername(),
                        authenticationRequest.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @GetMapping("/info")
    public UserInfo getUserInfo() {
        return userDetailsService.getUserInfo();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userService.registerNewUserAccount(user);
    }

    private Authentication authenticate(String username, String password) throws Exception {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new DisabledException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", e);
        }
    }
}
