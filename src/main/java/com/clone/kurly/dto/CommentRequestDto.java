package com.clone.kurly.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentRequestDto {
    private Long uid;
    private Long pid;
    private String comment;
    private String commentTitle;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Long commentId;

}
