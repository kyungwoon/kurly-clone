package com.clone.kurly.domain;

import com.clone.kurly.dto.CartItemRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Entity
public class CartItem extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long cartItemId;

    @Column
    private Long quantity;

    @ManyToOne
    @JoinColumn (name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn (name = "PRODUCT_ID")
    private Product Product;

    @ManyToOne
    @JoinColumn (name = "CART_ID")
    private Cart cart;


    public CartItem(CartItemRequestDto cartItemRequestDto, User user, Product product, Cart cart){
        this.quantity = cartItemRequestDto.getQuantity();
        this.user = user;
        this.product = product;
        this.cart = cart;
    }

    public void update (Long quantity) {
        this.quantity = quantity;
    }


}
