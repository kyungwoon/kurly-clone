package com.clone.kurly.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class MainProductResponseDto {
    private Long pid;
    private String mainImageUrl;
    private String name;
    private String shortDescription;
    private boolean isKurlyOnly;
    private boolean isSales;
    private Long originalPrice;
    private Long discountedPrice;
    private Long discountPercent;
    private int categoryNo;
    private String categoryName;
}