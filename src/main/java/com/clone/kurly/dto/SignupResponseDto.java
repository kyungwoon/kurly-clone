package com.clone.kurly.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SignupResponseDto {
    boolean result;
    private String username;

    public SignupResponseDto(boolean checkedresult){
        this.result = checkedresult;
    }

    public SignupResponseDto(String username) {
        this.username = username;
    }
}