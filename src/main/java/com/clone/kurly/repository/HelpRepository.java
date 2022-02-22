package com.clone.kurly.repository;

import com.clone.kurly.domain.Help;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HelpRepository extends JpaRepository<Help, Long> {

    Optional<Help>findByUidAndCommentId(Long uid, Long commentId);
    List<Help>findAllByCommentId(Long commentId);
}
