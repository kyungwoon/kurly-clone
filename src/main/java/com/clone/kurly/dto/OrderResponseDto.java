package com.clone.kurly.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderResponseDto {

    private List<OrderProductDto> orderProductDtoList;
    private Long uid;
    private Long deliveryPrice;
    private Long totalPrice;
    private String payMethod;
}
