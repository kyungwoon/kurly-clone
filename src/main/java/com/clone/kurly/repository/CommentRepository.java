package com.clone.kurly.repository;

import com.clone.kurly.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findByCommentId(Long commentId);
    List<Comment>findAllByProduct_Pid(Long pid);
}
