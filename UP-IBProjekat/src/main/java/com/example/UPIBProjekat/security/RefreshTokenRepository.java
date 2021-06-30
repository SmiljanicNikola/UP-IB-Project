package com.example.UPIBProjekat.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UPIBProjekat.model.User;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{

	
    @Override
    Optional<RefreshToken> findById(Long id);

    Optional<RefreshToken> findByToken(String token);

	int deleteByUser(User one);
}
