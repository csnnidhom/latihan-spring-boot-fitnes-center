package com.endpoints.fitnescenter.repository;

import com.endpoints.fitnescenter.entity.DetailLayanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetailLayananRepository extends JpaRepository<DetailLayanan, String> {

    Optional<DetailLayanan> findFirstByNamaLatihan(String namaLatihan);

}
