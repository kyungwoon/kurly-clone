package com.clone.kurly.service;

import com.clone.kurly.domain.CartItem;
import com.clone.kurly.dto.OrderProductDto;
import com.clone.kurly.dto.OrderResponseDto;
import com.clone.kurly.repository.CartItemRepository;
import com.clone.kurly.repository.CartRepository;
import com.clone.kurly.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserOrderService {

    private final UserOrderRepository userOrderRepository;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    @Autowired
    public UserOrderService(UserOrderRepository userOrderRepository,
                            CartItemRepository cartItemRepository,
                            CartRepository cartRepository){
        this.userOrderRepository = userOrderRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
    }



    //주문 생성
    public void processOrder(Long cid) {
        List<CartItem> cartItemList = cartItemRepository.findAllByCid(cid);

        Long uid = cartRepository.findByUid(cid).getUser().getUid(); //이거되나요?
        Long price = 0L;
        Long deliveryPrice = 2000L;
        Long totalPrice = 0L;
        String payMethod = "신용카드";

        List<OrderProductDto> orderProductDtoList = new ArrayList<>();
        for (CartItem cartItem : cartItemList) {
            price = cartItem.getProduct().getPrice; //이거되나요?
            totalPrice +=price;

            Long pid = cartItem.getProduct().getPid; //이거되나요?
            String name = cartItem.getProduct().getName; //이거되나요?
            String shortDescription = cartItem.getProduct().getShortDescription; //이거되나요?

            OrderProductDto orderProductDto = new OrderProductDto(pid, price, name,shortDescription );
            orderProductDtoList.add(orderProductDto);

        }

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderProductDtoList(orderProductDtoList);
        orderResponseDto.setUid(uid);
        orderResponseDto.setDeliveryPrice(deliveryPrice);
        orderResponseDto.setTotalPrice(totalPrice);
        orderResponseDto.setPayMethod(payMethod);


    }
}
