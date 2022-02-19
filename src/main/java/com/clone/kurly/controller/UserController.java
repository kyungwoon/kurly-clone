package com.clone.kurly.controller;

import com.clone.kurly.dto.SignupRequestDto;
import com.clone.kurly.dto.SignupResponseDto;
import com.clone.kurly.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class
UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/user/signup")
    public SignupResponseDto registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return new SignupResponseDto(true);
    }
}