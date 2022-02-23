package com.clone.kurly.controller;

import com.clone.kurly.dto.HelpRequestDto;
import com.clone.kurly.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelpController {

    private final HelpService helpService;

    @Autowired
    public HelpController(HelpService helpService) {
        this.helpService = helpService;

    }

    // 도움되었다 선택함
    @PostMapping("/api/comment/help")
    public Long commentHelp (@RequestBody HelpRequestDto helpRequestDto) {

        Long eid = helpService.commentHelp(helpRequestDto);

        return eid;
    }
}
