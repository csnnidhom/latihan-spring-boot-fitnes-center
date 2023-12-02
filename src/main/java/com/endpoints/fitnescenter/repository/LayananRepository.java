package com.endpoints.fitnescenter.repository;

import com.endpoints.fitnescenter.entity.Layanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LayananRepository extends JpaRepository<Layanan, String> {

}
