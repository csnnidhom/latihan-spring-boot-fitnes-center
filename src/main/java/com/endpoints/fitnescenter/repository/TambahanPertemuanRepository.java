package com.endpoints.fitnescenter.repository;

import com.endpoints.fitnescenter.entity.TambahanPertemuan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TambahanPertemuanRepository extends JpaRepository<TambahanPertemuan, String> {

    boolean existsByIdOrderAndTambahanLatihan(String idOrder, String namaLatihan);

    Optional<TambahanPertemuan> findFirstByIdOrderAndId(String idOrder, Integer idTambahanPertemuan);

}
