package com.clone.kurly.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pid;

    @Column
    private String no;

    @Column
    private String name;

    @Column
    private String shortDescription;

    @Column
    private boolean isKurlyOnly;

    @Column
    private boolean isSales;

    @Column
    private String unitText;

    @Column
    private String weight;

    @Column(length = 3000)
    private String contactAnt;

    @Column
    private String guides;

    @Column
    private String deliveryTimeType;

    @Column
    private String packingType;

    @Column
    private Long deliveryType;

    @Column
    private Long deliveryPrice;

    @Column
    private boolean isSoldOut;

    @Column
    private Long originalPrice;

    @Column
    private Long discountedPrice;

    @Column
    private Long discountPercent;

    @Column
    private String mainImageUrl;

    @Column
    private String listImageUrl;

    @Column
    private String detailImageUrl;

    @Column
    private int categoryNo;

    @Column
    private String categoryName;


}
