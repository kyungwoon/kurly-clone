package com.clone.kurly.controller;

import com.clone.kurly.domain.User;
import com.clone.kurly.dto.SignupRequestDto;
import com.clone.kurly.dto.SignupResponseDto;
import com.clone.kurly.security.UserDetailsImpl;
import com.clone.kurly.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class
UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/user/signup")
    public SignupResponseDto registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return new SignupResponseDto(true);
    }

    @PostMapping("/user/islogin")
    public SignupResponseDto islogin(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        System.out.println("username : " + user.getUsername());
        return new SignupResponseDto(user.getUsername());
    }

    //아이디 중복 확인
    @GetMapping("/user/signup/username")
    public boolean usernameCheck(@RequestBody SignupRequestDto signupRequestDto) {
        return userService.usernameCheck(signupRequestDto.getUsername());
    }
    //이메일 중복 확인
    @GetMapping("/user/signup/email")
    public boolean emailCheck(@RequestBody SignupRequestDto signupRequestDto) {
        return userService.emailCheck(signupRequestDto.getEmail());
    }

}