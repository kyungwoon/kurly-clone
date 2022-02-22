package com.clone.kurly.service;



import com.clone.kurly.domain.Comment;
import com.clone.kurly.domain.Help;
import com.clone.kurly.domain.Product;
import com.clone.kurly.dto.CommentRequestDto;
import com.clone.kurly.dto.CommentResponseDto;
import com.clone.kurly.repository.CommentRepository;
import com.clone.kurly.repository.HelpRepository;
import com.clone.kurly.repository.ProductRepository;
import com.clone.kurly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final HelpRepository helpRepository;


    @Autowired
    public CommentService(CommentRepository commentRepository,
                          ProductRepository productRepository,
                          UserRepository userRepository,
                          HelpRepository helpRepository ){
        this.commentRepository = commentRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.helpRepository = helpRepository;
    }

    //댓글생성
    public Comment createComment(CommentRequestDto commentRequestDto){

        Long pid = commentRequestDto.getPid();
        Product product = productRepository.findByPid(pid);

        Comment comment = new Comment(commentRequestDto, product);

        return comment;
    }

    // 댓글 조회
    public List<CommentResponseDto> showComment(Long pid) {

        List<Comment> commentList = commentRepository.findAllByPid(pid);

        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();

        for (Comment comment : commentList) {
            Long uid = comment.getUid();
            String nickname = userRepository.findById(uid).get().getNickname();
            String commentTitle  = comment.getCommentTitle();
            String comments  = comment.getComment();

            Long helpCount = 0L;
            Long commentId = comment.getCommentId();
            List<Help> helpList =helpRepository.findAllByCommentId(commentId);
            for (Help help : helpList) {
                if (help.isState()) {
                    helpCount +=1;
                }
            }

            CommentResponseDto commentResponseDto = new CommentResponseDto(uid, nickname, pid, commentTitle, comments, helpCount);
            commentResponseDtoList.add(commentResponseDto);
        }

        return commentResponseDtoList;

    }

    //댓글 삭제
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    //댓글 수정
    @Transactional
    public void updateComment(CommentRequestDto commentRequestDto) {
        Long commentId = commentRequestDto.getCommentId();

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()-> new NullPointerException("커맨트가 존재하지 않습니다.")
        );
        comment.update(commentRequestDto);

    }
}