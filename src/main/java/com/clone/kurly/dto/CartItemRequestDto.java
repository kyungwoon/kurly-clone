package com.clone.kurly.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartItemRequestDto {

    private Long uid;
    private Long pid;
    private String title;
    private Long price;
    private String img;
    private Long quantity;
    private Long cartItemId;

}
