package com.clone.kurly.repository;


import com.clone.kurly.domain.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {

    UserOrder findByUser_Id(Long id);
}
