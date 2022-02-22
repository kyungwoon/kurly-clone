package com.clone.kurly.controller;

import com.clone.kurly.domain.Product;
import com.clone.kurly.dto.MainPageResponseDto;
import com.clone.kurly.dto.MainProductResponseDto;
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

    // 전체상품조회
    @GetMapping("/api/main/all")
    public List<MainProductResponseDto> getProducts() {
        return productService.getAllProducts();
    }

    /*
    public class MainPageResponseDto {
    private ArrayList<MainProductResponseDto> banner_list;
    private ArrayList<MainProductResponseDto> sale_list;
    private ArrayList<MainProductResponseDto> review_list;
    private ArrayList<MainProductResponseDto> kurlyonly_list;
    private ArrayList<MainProductResponseDto> homestay_list;
    private ArrayList<MainProductResponseDto> md_list;
}

     */

    // 메인페이지 상품 조회
    @GetMapping("/api/main")
    public MainPageResponseDto getMainPageProductList(){
        MainPageResponseDto mainProductList = new MainPageResponseDto();
        mainProductList.setBanner_list(productService.getMainBannerList());
        mainProductList.setSale_list(productService.getMainSaleList());
        mainProductList.setKurlyonly_list(productService.getMainKurlyOnlyList());
//        mainProductList.setHomestay_list(productService.getMainHomeStayList());
        mainProductList.setMd_list(productService.getMainMDDefList());
        return mainProductList;
    }


    //랜덤 상품 조회
    @GetMapping("/api/main/random")
    public List<MainProductResponseDto> getMainRandomList(){
        return productService.getMainMDDefList();
    }


    //상세상품조회
    @GetMapping("/api/products/{pid}")
    public Product detailProduct(@PathVariable Long pid) {
        return productService.detailProduct(pid);
    }
}




//    // 내가 올린 게시글 조회
//    @GetMapping("/myarticle")
//    public List<ArticleResponseDto> getMyArticles(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return articleService.getMyArticle(userDetails);
//    }
//

//
//    // 좋아요 한 게시글 검색
//    @GetMapping("/mylike")
//    public List<ArticleResponseDto> getMyLikeArticles(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return articleService.getMyLikeArticle(userDetails);
//    }
//
//
//    //게시글 삭제하기
//     @DeleteMapping("/pictures/{articleId}")
//     public void deleteArticles(@PathVariable Long articleId) {
//     articleService.deleteArticle(articleId);
//    }
//
//
//}