package com.clone.kurly.service;

import com.clone.kurly.domain.Comment;
import com.clone.kurly.domain.Help;
import com.clone.kurly.dto.HelpRequestDto;
import com.clone.kurly.repository.CommentRepository;
import com.clone.kurly.repository.HelpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelpService {

    private final CommentRepository commentRepository;
    private final HelpRepository helpRepository;

    @Autowired
    public HelpService(CommentRepository commentRepository, HelpRepository helpRepository ){
        this.commentRepository = commentRepository;
        this.helpRepository = helpRepository;
    }

    // 도움되었다 선택함
    public Long commentHelp(HelpRequestDto helpRequestDto) {

        Long uid = helpRequestDto.getUid();
        Long commentId = helpRequestDto.getCommentId();
        Comment comment = commentRepository.findByCommentId(commentId);

        //Help 기존에 존재하는지 확인
        if(helpRepository.findByUidAndComment_CommentId(uid,commentId).isPresent()) {

            System.out.println("help 기존에 존재함 해당 help 삭제 후 0 내보낼 것");

            Help help = helpRepository.findByUidAndComment_CommentId(uid,commentId).orElseThrow(
                    ()-> new NullPointerException("아이디가 존재하지 않습니다."));
            helpRepository.delete(help);
//
//            help.update(helpRequestDto);
//            helpRepository.save(help);
//
//            System.out.println("도움이 되었어요 수정, 도움된 커맨트 id :" + commentId);
//            System.out.println("도움 누른 사람id :" + uid);

            return 0L;

            // Help 기존에 없으면 생성함
        } else {
            Help help = new Help (helpRequestDto, comment);
            helpRepository.save(help);

            System.out.println("도움이 되었어요 새로 생성, 도움된 커맨트 id :" + commentId);
            System.out.println("도움 누른 사람id :" + uid);

            return help.getEid();
        }

    }
}
