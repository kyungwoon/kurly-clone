package com.clone.kurly.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProductDto {

    private Long pid;
    private Long price;
    private String name;
    private String shortDescription;

    public OrderProductDto(Long pid, Long price, String name, String shortDescription) {
        this.pid = pid;
        this.price = price;
        this.name =name;
        this.shortDescription =shortDescription;
    }
}
