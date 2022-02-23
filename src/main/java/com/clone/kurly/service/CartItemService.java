package com.clone.kurly.service;

import com.clone.kurly.domain.*;
import com.clone.kurly.dto.CartItemRequestDto;
import com.clone.kurly.repository.CartItemRepository;
import com.clone.kurly.repository.CartRepository;
import com.clone.kurly.repository.ProductRepository;
import com.clone.kurly.repository.UserRepository;
import com.clone.kurly.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;


    @Autowired
    public CartItemService(UserRepository userRepository,
                           ProductRepository productRepository,
                           CartRepository cartRepository,
                           CartItemRepository cartItemRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }



//    // 카트 생성
//    public Long createCart(Long uid) {
//
//        User user = userRepository.findById(uid).orElseThrow(
//                ()-> new NullPointerException("유저가 존재하지 않습니다."));
//
//        Cart cart = new Cart (user);
//        cartRepository.save(cart);
//        System.out.println("유저 카트 생성");
//
//        Long cid = cart.getCid();
//
//        return cid;
//    }

    // 카트 조회 (장바구니 조회)
    public List<CartItemRequestDto> showCart(Long uid) {

        Cart cart = cartRepository.findByUser_Id(uid).orElseThrow(
                ()-> new NullPointerException("카트가 존재하지 않습니다."));
        Long cid = cart.getCid();

        List<CartItem>cartItemList = cartItemRepository.findAllByCart_Cid(cid);

        List<CartItemRequestDto> cartItemRequestDtoList = new ArrayList<>();
        for (CartItem cartItem : cartItemList) {
            Long pid = cartItem.getProduct().getPid();
            Product product = productRepository.findByPid(pid);

            String title = product.getName();
            Long price =product.getDiscountedPrice();
            String img =product.getDetailImageUrl();
            Long quantity =cartItem.getQuantity();
            Long cartItemId =cartItem.getCartItemId();

            CartItemRequestDto cartItemRequestDto = new CartItemRequestDto();
            cartItemRequestDto.setUid(uid);
            cartItemRequestDto.setPid(pid);
            cartItemRequestDto.setTitle(title);
            cartItemRequestDto.setPrice(price);
            cartItemRequestDto.setImg(img);
            cartItemRequestDto.setQuantity(quantity);
            cartItemRequestDto.setCartItemId(cartItemId);

            cartItemRequestDtoList.add(cartItemRequestDto);
        }


        return cartItemRequestDtoList;

    }


    // 카트 아이템 생성 (장바구니 등록)
    public Long createCartItem(CartItemRequestDto cartItemRequestDto) {

        Long uid = cartItemRequestDto.getUid();
        Long pid = cartItemRequestDto.getPid();

        User user = userRepository.findById(uid).orElseThrow(
                ()-> new NullPointerException("유저가 존재하지 않습니다."));

//        // 카트 없을 시 생성
//        if(cartRepository.findByUser_Id(uid).isPresent()) {
//
//        } else {
//            Cart cart = new Cart (user);
//            cartRepository.save(cart);
//            System.out.println("유저 카트 생성");
//        }

        Product product = productRepository.findByPid(pid);

        Cart cart = cartRepository.findByUser_Id(uid).orElseThrow(
                ()-> new NullPointerException("카트가 존재하지 않습니다."));

        CartItem cartItem = new CartItem(cartItemRequestDto, user, product, cart);

        cartItemRepository.save(cartItem);
        System.out.println("카트아이템 생성완료");

        Long cartItemId = cartItem.getCartItemId();

        return cartItemId;

    }

    // 카트 아이템 삭제
    public void deleteCartItem(Long pid, UserDetailsImpl userDetails){
        Long uid = userDetails.getId();
        Long cartItemId = cartItemRepository.findByUser_IdAndProduct_Pid(uid,pid).getCartItemId();

        cartItemRepository.deleteById(cartItemId);
        System.out.println("카트 아이템 삭제 카트아이템 id : " + cartItemId);
    }

    // 카트 아이템 수량 수정
    @Transactional
    public void updateCartItem(CartItemRequestDto cartItemRequestDto, UserDetailsImpl userDetails) {
        Long uid = userDetails.getId();
        Long pid = cartItemRequestDto.getPid();

        Long quantity = cartItemRequestDto.getQuantity();
        Long cartItemId = cartItemRepository.findByUser_IdAndProduct_Pid(uid,pid).getCartItemId();

        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(
                ()-> new NullPointerException("카트 아이템이 존재하지 않습니다."));

        cartItem.update(quantity);
    }
}