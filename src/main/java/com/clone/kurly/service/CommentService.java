package com.clone.kurly.service;



import com.clone.kurly.domain.Comment;
import com.clone.kurly.domain.Help;
import com.clone.kurly.domain.Product;
import com.clone.kurly.domain.User;
import com.clone.kurly.dto.CommentRequestDto;
import com.clone.kurly.dto.CommentResponseDto;
import com.clone.kurly.repository.CommentRepository;
import com.clone.kurly.repository.HelpRepository;
import com.clone.kurly.repository.ProductRepository;
import com.clone.kurly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

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
        commentRepository.save(comment);

        int commentCount = commentRepository.countAllByProduct_Pid(pid);
        product.setCommentCount(commentCount);
        productRepository.save(product);

        return comment;
    }

    // 댓글 조회
    public List<CommentResponseDto> showComment(Long pid) {

        List<Comment> commentList = commentRepository.findAllByProduct_Pid(pid);
        String productName = productRepository.findByPid(pid).getName();
        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();

        for (Comment comment : commentList) {

            Long uid = comment.getUid();
            //String nickname = userRepository.findById(uid).get().getNickname();
            User user = userRepository.findById(uid).orElseThrow(
                    ()-> new NullPointerException("유저가 존재하지 않습니다.")
            );
            String nickname = user.getNickname();


            Long helpCount = 0L;
            Long commentId = comment.getCommentId();
            List<Help> objectHelpList =helpRepository.findAllByComment_CommentId(commentId);

            helpCount = (long) objectHelpList.size();

            //List<Long> helpList = new ArrayList<>();
            List<Map<String, Long>>helpList = new ArrayList<Map<String, Long>>();

            for (Help help : objectHelpList) {
                Map<String,Long> map = new HashMap<String,Long>();
                map.put("uid",help.getUid());
                helpList.add(map);
                //helpList.add(help.getUid());
            }

            CommentResponseDto commentResponseDto = new CommentResponseDto(comment, nickname, pid,productName, helpCount, helpList);
            commentResponseDtoList.add(commentResponseDto);
        }

        return commentResponseDtoList;

    }

    //댓글 삭제
    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()-> new NullPointerException("유저가 존재하지 않습니다.")
        );

        Product product = comment.getProduct();

        //댓글 안에 도움됬어요 전부 삭제
        helpRepository.deleteAllByComment_CommentId(commentId);
        System.out.println("댓글 도움됬어요 전부 삭제 선진행 완료");

        //댓글 삭제
        commentRepository.deleteById(commentId);
        System.out.println("댓글 삭제 완료 commentId: " + commentId);


        int commentCount = commentRepository.countAllByProduct_Pid(product.getPid());
        product.setCommentCount(commentCount);
        productRepository.save(product);
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