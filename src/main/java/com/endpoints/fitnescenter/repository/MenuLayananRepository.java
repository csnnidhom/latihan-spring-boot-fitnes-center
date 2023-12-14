package com.endpoints.fitnescenter.repository;

import com.endpoints.fitnescenter.entity.MenuLayanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuLayananRepository extends JpaRepository<MenuLayanan, String> {

    Optional<MenuLayanan> findFirstByNamaPaket(String namaPaket);
}
