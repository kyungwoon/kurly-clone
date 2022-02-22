package com.clone.kurly.repository;


import com.clone.kurly.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {


    Cart findByUser_Id(Long uid);
}
