package com.clone.kurly.controller;

import com.clone.kurly.domain.Comment;
import com.clone.kurly.dto.CommentRequestDto;
import com.clone.kurly.dto.CommentResponseDto;
import com.clone.kurly.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;

    }


    //  댓글 생성
    @PostMapping("/api/comment/create")
    public Long createComment(@RequestBody CommentRequestDto commentRequestDto) {

        System.out.println("댓글 생성 내용 : "+commentRequestDto.getComment());
        System.out.println("댓글 생성  유저아디 : "+commentRequestDto.getUid());
        System.out.println("상품 productId : "+commentRequestDto.getPid());

        Comment comment = commentService.createComment(commentRequestDto);

        Long commentId = comment.getCommentId();

        return commentId;
    }


    //댓글 조회
    @GetMapping("/api/comment/{pid}")
    public List<CommentResponseDto> showComment (@PathVariable Long pid) {
        System.out.println("댓글조회 진행 중");
        List<CommentResponseDto> commentList = commentService.showComment(pid);
        return commentList;

    }

    //댓글 삭제
    @DeleteMapping("/api/comment/{commentId}")
    public Long deleteComment (@PathVariable Long commentId) {
        System.out.println("댓글 삭제 진행 중");
        commentService.deleteComment(commentId);
        return commentId;
    }

    //댓글 수정
    @PutMapping("/api/comment/{commentId}")
    public Long updateComment(@RequestBody CommentRequestDto commentRequestDto ) {
        commentService.updateComment(commentRequestDto);
        return commentRequestDto.getCommentId();
    }




}
