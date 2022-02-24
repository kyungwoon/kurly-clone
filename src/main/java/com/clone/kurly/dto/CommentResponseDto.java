package com.clone.kurly.dto;

import com.clone.kurly.domain.Comment;
import com.clone.kurly.domain.Help;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class CommentResponseDto {
    private Long commentId;
    private Long uid;
    private String commentTitle;
    private String comment;
    private LocalDateTime createdAt;
    private String nickname;
    private Long pid;
    private String productName;
    private Long helpCount;
    private List<Map<String, Long>>helpList;


    public CommentResponseDto(Comment comment, String nickname, Long pid,String productName, Long helpCount, List<Map<String, Long>>helpList) {
        this.commentId = comment.getCommentId();
        this.uid = comment.getUid();
        this.commentTitle = comment.getCommentTitle();
        this.comment = comment.getComment();
        this.createdAt = comment.getCreatedAt();
        this.nickname = nickname;
        this.pid = pid;
        this.productName = productName;
        this.helpCount = helpCount;
        this.helpList= helpList;
    }

}
