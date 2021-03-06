package com.example.UPIBProjekat.security;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.UPIBProjekat.Repository.UserRepository;

@Service
public class RefreshTokenService {
	
	  @Value("1500000")
	  private Long refreshTokenDurationMs;

	  
	  @Autowired
	  private RefreshTokenRepository refreshTokenRepository;

	  @Autowired
	  private UserRepository userRepository;

	  public Optional<RefreshToken> findByToken(String token) {
	    return refreshTokenRepository.findByToken(token);
	  }

	  public RefreshToken createRefreshToken(Integer userId) {
	    RefreshToken refreshToken = new RefreshToken();

	    refreshToken.setUser(userRepository.getOne(userId));
	    refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
	    refreshToken.setToken(UUID.randomUUID().toString());

	    refreshToken = refreshTokenRepository.save(refreshToken);
	    return refreshToken;
	  }

	  public RefreshToken verifyExpiration(RefreshToken token) {
	    if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
	      refreshTokenRepository.delete(token);
	      throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
	    }

	    return token;
	  }

	  @Transactional
	  public int deleteByUserId(Integer userId) {
	    return refreshTokenRepository.deleteByUser(userRepository.getOne(userId));
	  }
}
