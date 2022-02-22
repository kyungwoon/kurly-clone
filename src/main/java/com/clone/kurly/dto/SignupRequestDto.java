package com.clone.kurly.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequestDto {
    private String username;
    private String nickname;
    private String email;
    private String password;
    private String passwordCheck;
}
