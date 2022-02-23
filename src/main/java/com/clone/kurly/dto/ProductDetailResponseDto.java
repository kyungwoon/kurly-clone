package com.clone.kurly.dto;

import com.clone.kurly.domain.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor

public class ProductDetailResponseDto {
    private Product product;
    private List<CommentResponseDto> commentResponseDtoList;
}