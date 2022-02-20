package com.clone.kurly.dto;

import lombok.Getter;

@Getter
public class SignupRequestDto {
    private String username;
    private String nickname;
    private String email;
    private String password;
    private String passwordCheck;
}
