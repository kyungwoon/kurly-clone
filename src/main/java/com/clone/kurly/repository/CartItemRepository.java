package com.clone.kurly.repository;

import com.clone.kurly.domain.Cart;
import com.clone.kurly.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findAllByCart_Cid(Long cid);


}
