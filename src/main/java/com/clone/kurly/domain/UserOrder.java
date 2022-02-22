package com.clone.kurly.domain;

import com.clone.kurly.dto.CartItemRequestDto;
import com.clone.kurly.dto.OrderProductDto;
import com.clone.kurly.dto.OrderResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class UserOrder extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long oid;

    @ManyToOne
    @JoinColumn (name = "CART_ID")
    private Cart cart;


    public UserOrder(Cart cart){
        this.cart = cart;
    }


}
