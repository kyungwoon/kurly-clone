package com.clone.kurly.controller;

import com.clone.kurly.domain.Product;
import com.clone.kurly.dto.MainPageResponseDto;
import com.clone.kurly.dto.MainProductResponseDto;
import com.clone.kurly.dto.ProductDetailResponseDto;
import com.clone.kurly.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;

    // 전체상품조회 - 무서운 일이 일어날 수 있으니 되도록 하지 마세요...
    @GetMapping("/api/main/all")
    public List<MainProductResponseDto> getProducts() {
        return productService.getAllProducts();
    }

    // 메인페이지 상품 조회
    @GetMapping("/api/main")
    public MainPageResponseDto getMainPageProductList(){
        MainPageResponseDto mainProductList = new MainPageResponseDto();
        mainProductList.setBanner_list(productService.getMainBannerList());
        mainProductList.setSale_list(productService.getMainSaleList());
        mainProductList.setReview_list(productService.getMainReviewList());
        mainProductList.setKurlyonly_list(productService.getMainKurlyOnlyList());
        mainProductList.setHomestay_list(productService.getMainCategoryList(724)); //with shuffle, 홈캉스
        mainProductList.setMd_list(productService.getMainMDList(907)); //withoutshuffle, def: 채소
        return mainProductList;
    }

    // 메인 엠디리스트 조회
    @GetMapping("/api/main/md/{categoryNo}")
    public List<MainProductResponseDto> getMainMDList(@PathVariable int categoryNo){
        return productService.getMainMDList(categoryNo);
    }



    //상세상품조회 : 상세 상품 내역, 댓글[{댓글 id, 작성자, 댓글 제목 & 내용 , 도움이 돼요 누른 사용자 리스트}]
    @GetMapping("/api/products/{pid}")
    public ProductDetailResponseDto detailProduct(@PathVariable Long pid) {
        return productService.detailProduct(pid);
    }
}