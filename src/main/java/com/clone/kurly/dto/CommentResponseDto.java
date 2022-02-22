package com.clone.kurly.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentResponseDto {

    private Long uid;
    private String nickname;
    private Long pid;
    private String commentTitle;
    private String comment;
    private Long helpCount;

    public CommentResponseDto(Long uid, String nickname, Long pid, String commentTitle, String comment, Long helpCount) {
        this.uid = uid;
        this.nickname = nickname;
        this.pid = pid;
        this.commentTitle = commentTitle;
        this.comment = comment;
        this.helpCount = helpCount;
    }

}
