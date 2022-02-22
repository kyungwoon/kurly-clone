package com.clone.kurly.controller;

import com.clone.kurly.dto.CartItemRequestDto;
import com.clone.kurly.security.UserDetailsImpl;
import com.clone.kurly.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartItemController {

    private final CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;

    }

     //회원 가입 시 카트 생성
    @PostMapping("/api/user/cart/{uid}")
    public Long createCart(@RequestParam Long uid) {

        System.out.println("유저 카트 생성  유저id : "+uid );

        Long cid = cartItemService.createCart(uid);

        return cid;
    }


    // 카트 조회 (장바구니 조회)
    @GetMapping("/api/carts")
    public List<CartItemRequestDto> showCart(@AuthenticationPrincipal UserDetailsImpl userDetails) {

        Long uid = userDetails.getId();
        System.out.println("유저 카트 조회  유저id : "+ uid );

        List<CartItemRequestDto> cartItemRequestDtoList = cartItemService.showCart(uid);
        return cartItemRequestDtoList;
    }


    // 카트 아이템 생성 (장바구니 등록)
    @PostMapping("/api/carts/${pid}")
    public Long createCart(@RequestBody CartItemRequestDto cartItemRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        if(userDetails ==null) {
//            cartItemRequestDto.setUid(0L);
//            System.out.println("상품 등록  유저id : "+cartItemRequestDto.getUid());
//            System.out.println("상품 등록  프로덕트Id : "+cartItemRequestDto.getPid());
//            Long cartItemId = cartItemService.createCartItem(cartItemRequestDto);
            return 0L;

        }else{
            Long uid = userDetails.getId();
            cartItemRequestDto.setUid(uid);
            System.out.println("상품 등록  유저id : "+cartItemRequestDto.getUid());
            System.out.println("상품 등록  프로덕트Id : "+cartItemRequestDto.getPid());
            Long cartItemId = cartItemService.createCartItem(cartItemRequestDto);
            return cartItemId;

        }

    }

    // 카트 아이템 삭제
    @DeleteMapping("/api/carts/{cartItemId}")
    public Long deleteCartItem(@RequestParam Long cartItemId) {
        cartItemService.deleteCartItem(cartItemId);
        return cartItemId;
    }

    //카트 아이템 수량 수정
    @PutMapping("/api/carts/{cartItemId}")
    public Long updateCartItem(@RequestBody CartItemRequestDto cartItemRequestDto) {
        cartItemService.updateCartItem(cartItemRequestDto);
        return cartItemRequestDto.getCartItemId();
    }



}
