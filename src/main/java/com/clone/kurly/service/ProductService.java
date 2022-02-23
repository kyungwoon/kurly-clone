package com.clone.kurly.service;

import com.clone.kurly.domain.Product;
import com.clone.kurly.dto.CommentResponseDto;
import com.clone.kurly.dto.MainProductResponseDto;
import com.clone.kurly.dto.ProductDetailResponseDto;
import com.clone.kurly.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CommentService commentService;

    @Transactional
    public List<MainProductResponseDto> getAllProducts() {
        //반환할 리스트
        List<MainProductResponseDto> productList = new ArrayList<>();
        List<Product> rawProductData = productRepository.findAll();
        for(Product eachProduct : rawProductData){
            MainProductResponseDto product = new MainProductResponseDto();
            product.setPid(eachProduct.getPid());
            product.setMainImageUrl(eachProduct.getMainImageUrl());
            product.setName(eachProduct.getName());
            product.setShortDescription(eachProduct.getShortDescription());
            product.setOriginalPrice(eachProduct.getOriginalPrice());
            product.setDiscountedPrice(eachProduct.getDiscountedPrice());
            product.setDiscountPercent(eachProduct.getDiscountPercent());

            productList.add(product);
        }
        return productList;
    }

    //Product product &  List<CommentResponseDto> commentResponseDtoList;
    public ProductDetailResponseDto detailProduct(Long pid) {
        Optional<Product> productOptional = productRepository.findById(pid);
        Product product = productOptional.get();
        List<CommentResponseDto> commentList = commentService.showComment(pid);

        ProductDetailResponseDto productDetailResponseDto = new ProductDetailResponseDto();
        productDetailResponseDto.setProduct(product);
        productDetailResponseDto.setCommentResponseDtoList(commentList);

        return productDetailResponseDto;
    }

    public List<MainProductResponseDto> getMainBannerList(){
        //banner_list : 메인 배너 리스트 (product No 높은 순 8개 (랜덤으로 바꿔보기))
        //배너 리스트 템플렛
        List<MainProductResponseDto> productBannerList = new ArrayList<>();
        List<Product> rawProductData = productRepository.findTop8ByOrderByNoDesc();
        for(Product eachProduct : rawProductData){
            MainProductResponseDto product = new MainProductResponseDto();
            product.setPid(eachProduct.getPid());
            product.setMainImageUrl(eachProduct.getMainImageUrl());
            product.setName(eachProduct.getName());
            product.setShortDescription(eachProduct.getShortDescription());
            product.setOriginalPrice(eachProduct.getOriginalPrice());
            product.setDiscountedPrice(eachProduct.getDiscountedPrice());
            product.setDiscountPercent(eachProduct.getDiscountPercent());
            product.setKurlyOnly(eachProduct.isKurlyOnly());
            product.setCategoryNo(eachProduct.getCategoryNo());
            product.setCategoryName(eachProduct.getCategoryName());

            productBannerList.add(product);
        }
        return productBannerList;
    }

    public List<MainProductResponseDto> getMainSaleList(){
        //세일 리스트 템플렛
        //sale_list : 세일 제품 (세일 가장 높은 순으로 8개)
        List<MainProductResponseDto> productSaleList = new ArrayList<>();
        List<Product> rawProductSaleData = productRepository.findTop8ByOrderByDiscountPercentDesc();
        for(Product eachProduct : rawProductSaleData){
            MainProductResponseDto product = new MainProductResponseDto();
            product.setPid(eachProduct.getPid());
            product.setMainImageUrl(eachProduct.getMainImageUrl());
            product.setName(eachProduct.getName());
            product.setShortDescription(eachProduct.getShortDescription());
            product.setOriginalPrice(eachProduct.getOriginalPrice());
            product.setDiscountedPrice(eachProduct.getDiscountedPrice());
            product.setDiscountPercent(eachProduct.getDiscountPercent());
            product.setKurlyOnly(eachProduct.isKurlyOnly());
            product.setCategoryNo(eachProduct.getCategoryNo());
            product.setCategoryName(eachProduct.getCategoryName());

            productSaleList.add(product);
        }
        return productSaleList;
    }

    public List<MainProductResponseDto> getMainKurlyOnlyList(){
        List<Product> productList = productRepository.findAllByIsKurlyOnly(true);

        List<Integer> randomNumber = new ArrayList<>();
        for(int i = 1; i< productList.size(); i++){
            randomNumber.add(i);
        }
        Collections.shuffle(randomNumber);

        List<Product> selectedProductList = new ArrayList<>();
        for(int i=0; i<8; i++){
            Product product = productList.get(randomNumber.get(i));
            selectedProductList.add(product);
        }

        List <MainProductResponseDto> productKurlyOnlyList = new ArrayList<>();
        for(Product eachProduct : selectedProductList){
            MainProductResponseDto product = new MainProductResponseDto();
            product.setPid(eachProduct.getPid());
            product.setMainImageUrl(eachProduct.getMainImageUrl());
            product.setName(eachProduct.getName());
            product.setShortDescription(eachProduct.getShortDescription());
            product.setOriginalPrice(eachProduct.getOriginalPrice());
            product.setDiscountedPrice(eachProduct.getDiscountedPrice());
            product.setDiscountPercent(eachProduct.getDiscountPercent());
            product.setKurlyOnly(eachProduct.isKurlyOnly());
            product.setCategoryNo(eachProduct.getCategoryNo());
            product.setCategoryName(eachProduct.getCategoryName());

            productKurlyOnlyList.add(product);
        }
        return productKurlyOnlyList;
    }

    //셔플 있음 (홈캉스 메인 노출에 이용)
    public List<MainProductResponseDto> getMainCategoryList(int categoryNo){
        List<Product> productList = productRepository.findAllByCategoryNo(categoryNo);

        List<Integer> randomNumber = new ArrayList<>();
        for(int i = 1; i< productList.size(); i++){
            randomNumber.add(i);
        }
        Collections.shuffle(randomNumber);

        List<Product> selectedProductList = new ArrayList<>();
        for(int i=0; i<8; i++){
            Product product = productList.get(randomNumber.get(i));
            selectedProductList.add(product);
        }

        List <MainProductResponseDto> productHomeStayList = new ArrayList<>();
        for(Product eachProduct : selectedProductList){
            MainProductResponseDto product = new MainProductResponseDto();
            product.setPid(eachProduct.getPid());
            product.setMainImageUrl(eachProduct.getMainImageUrl());
            product.setName(eachProduct.getName());
            product.setShortDescription(eachProduct.getShortDescription());
            product.setOriginalPrice(eachProduct.getOriginalPrice());
            product.setDiscountedPrice(eachProduct.getDiscountedPrice());
            product.setDiscountPercent(eachProduct.getDiscountPercent());
            product.setKurlyOnly(eachProduct.isKurlyOnly());
            product.setCategoryNo(eachProduct.getCategoryNo());
            product.setCategoryName(eachProduct.getCategoryName());

            productHomeStayList.add(product);
        }
        return productHomeStayList;
    }

    //셔플 없이 (MD 상품 노출에 이용)
    public List<MainProductResponseDto> getMainMDList(int categoryNo) {
        List<Product> rawProductList = productRepository.findByCategoryNoOrderByOriginalPriceDesc(categoryNo);

        List <MainProductResponseDto> productMainMDList = new ArrayList<>();
        for(Product eachProduct : rawProductList){
            MainProductResponseDto product = new MainProductResponseDto();
            product.setPid(eachProduct.getPid());
            product.setMainImageUrl(eachProduct.getMainImageUrl());
            product.setName(eachProduct.getName());
            product.setShortDescription(eachProduct.getShortDescription());
            product.setOriginalPrice(eachProduct.getOriginalPrice());
            product.setDiscountedPrice(eachProduct.getDiscountedPrice());
            product.setDiscountPercent(eachProduct.getDiscountPercent());
            product.setKurlyOnly(eachProduct.isKurlyOnly());
            product.setCategoryNo(eachProduct.getCategoryNo());
            product.setCategoryName(eachProduct.getCategoryName());

            productMainMDList.add(product);
        }
        return productMainMDList;
    }

    public List<MainProductResponseDto> getMainReviewList() {
        List<MainProductResponseDto> productList = new ArrayList<>();
        List<Product> rawProductReviewData = productRepository.findTop8ByOrderByCommentCountDesc();
        for(Product eachProduct : rawProductReviewData){
            MainProductResponseDto product = new MainProductResponseDto();
            product.setPid(eachProduct.getPid());
            product.setMainImageUrl(eachProduct.getMainImageUrl());
            product.setName(eachProduct.getName());
            product.setShortDescription(eachProduct.getShortDescription());
            product.setOriginalPrice(eachProduct.getOriginalPrice());
            product.setDiscountedPrice(eachProduct.getDiscountedPrice());
            product.setDiscountPercent(eachProduct.getDiscountPercent());
            product.setKurlyOnly(eachProduct.isKurlyOnly());
            product.setCategoryNo(eachProduct.getCategoryNo());
            product.setCategoryName(eachProduct.getCategoryName());

            productList.add(product);
        }
        return productList;

    }



}
