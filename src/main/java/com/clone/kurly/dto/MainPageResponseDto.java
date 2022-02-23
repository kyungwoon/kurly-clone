package com.clone.kurly.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
public class MainPageResponseDto {
    private List<MainProductResponseDto> banner_list;
    private List<MainProductResponseDto> sale_list;
    private List<MainProductResponseDto> review_list;
    private List<MainProductResponseDto> kurlyonly_list;
    private List<MainProductResponseDto> homestay_list;
    private List<MainProductResponseDto> md_list;
}