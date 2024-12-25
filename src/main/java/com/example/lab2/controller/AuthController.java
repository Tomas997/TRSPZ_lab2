package com.example.lab2.controller;

import com.example.lab2.controller.auth.JwtAuthenticationResponse;
import com.example.lab2.dto.user.UserSignIn;
import com.example.lab2.dto.user.UserSignUp;
import com.example.lab2.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;


    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid UserSignUp request) {
        return authenticationService.signUp(request);
    }

    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid UserSignIn request) {
        return authenticationService.signIn(request);
    }
}
