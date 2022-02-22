package com.clone.kurly.controller;

import com.clone.kurly.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserOrderController {

    private final UserOrderService userOrderService;

    @Autowired
    public UserOrderController(UserOrderService userOrderService) {
        this.userOrderService = userOrderService;

    }

    // 주문 생성
    @PostMapping("/api/orders")
    public Long createCart(@RequestBody Long cid) {

        System.out.println("유저 주문 생성  cid : "+ cid );

        userOrderService.processOrder(cid);

        return cid;
    }




}
