package com.endpoints.fitnescenter.repository;

import com.endpoints.fitnescenter.entity.OrderPaket;
import com.endpoints.fitnescenter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderPaketRepository extends JpaRepository<OrderPaket, Integer> {

    Optional<OrderPaket> findByUser(User user);

    Optional<OrderPaket> findFirstById(String idOrder);

    boolean existsByUser(User user);



}
