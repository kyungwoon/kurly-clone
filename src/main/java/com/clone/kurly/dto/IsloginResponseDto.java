package com.clone.kurly.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class IsloginResponseDto {

    private String username;
    private String nickname;
    private Long id;


//    public IsloginResponseDto(String username, String nickname) {
//        this.username = username;
//        this.nickname = nickname;
//    }
}
