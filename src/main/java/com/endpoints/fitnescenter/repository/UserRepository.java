package com.endpoints.fitnescenter.repository;

import com.endpoints.fitnescenter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsUserByEmail(String email);

    Optional<User> findFirstByEmail(String email);

    Optional<User> findFirstByToken(String Token);

}
