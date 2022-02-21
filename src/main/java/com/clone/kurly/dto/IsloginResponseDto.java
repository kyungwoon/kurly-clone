package com.clone.kurly.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class IsloginResponseDto {
    private String username;


    public IsloginResponseDto(String username) {
        this.username = username;
    }
}
