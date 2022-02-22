package com.clone.kurly.domain;

import com.clone.kurly.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long commentId;

    @Column
    private String commentTitle ;

    @Column
    private String comment;

    @Column
    private Long uid;

    @ManyToOne
    @JoinColumn (name = "PRODUCT_ID")
    private Product product;


    public Comment(CommentRequestDto commentRequestDto, Product product){
        this.uid = commentRequestDto.getUid();
        this.comment = commentRequestDto.getComment();
        this.commentTitle = commentRequestDto.getCommentTitle();
        this.product =product;
    }


    public void update(CommentRequestDto commentRequestDto){
        this.comment = commentRequestDto.getComment();
    }


}
