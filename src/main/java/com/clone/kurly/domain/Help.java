package com.clone.kurly.domain;

import com.clone.kurly.dto.HelpRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Entity
public class Help {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long eid;

    @Column
    private boolean state ;

    @Column
    private Long uid;

    @ManyToOne
    @JoinColumn (name = "COMMENT_ID")
    private Comment comment;

    public Help(HelpRequestDto helpRequestDto, Comment comment) {
        this.state = helpRequestDto.isState();
        this.uid = helpRequestDto.getUid();
        this.comment = comment;
    }

    public void update (HelpRequestDto helpRequestDto) {
        this.state =helpRequestDto.isState();
    }

}
