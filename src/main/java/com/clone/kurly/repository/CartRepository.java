package com.clone.kurly.repository;


import com.clone.kurly.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {


    Optional<Cart> findByUser_Id(Long id);
}
