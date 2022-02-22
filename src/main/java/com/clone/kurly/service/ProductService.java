package com.clone.kurly.service;

import com.clone.kurly.domain.Product;
import com.clone.kurly.dto.MainProductResponseDto;
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

    public Product detailProduct(Long pid) {
        Optional<Product> productOptional = productRepository.findById(pid);
        Product product = productOptional.get();
        return product;
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

    public List<MainProductResponseDto> getMainHomeStayList(){
        List<Product> productList = productRepository.findAllByCategoryNo(724);

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

    public List<MainProductResponseDto> getMainMDDefList() {
        List<Product> productList = productRepository.findAllByCategoryNo(907);

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

        List <MainProductResponseDto> productMainMDdefList = new ArrayList<>();
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

            productMainMDdefList.add(product);
        }
        return productMainMDdefList;
    }


}
