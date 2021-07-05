package com.example.UPIBProjekat.service;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UPIBProjekat.Repository.VerificationTokenRepository;
import com.example.UPIBProjekat.model.User;
import com.example.UPIBProjekat.model.VerificationToken;

@Service
public class VerificationTokenService {

	private final VerificationTokenRepository verificationTokenRepository;

	@Autowired
	public VerificationTokenService(VerificationTokenRepository verificationTokenRepository) {
		super();
		this.verificationTokenRepository = verificationTokenRepository;
	}
	
	public VerificationToken findByToken(String token) {
		return verificationTokenRepository.findByToken(token);
	}
	
	@Transactional
	public VerificationToken findByUser(User user) {
		return verificationTokenRepository.findByUser(user);
	}
	
	@Transactional
	public void save(User user, String token) {
		VerificationToken verificationToken = new VerificationToken(token, user);
		//Postavljamo na 24h
		verificationToken.setExpiryDate(calculateExpiryDate(24*68));
		verificationTokenRepository.save(verificationToken);
	}
	
	private Timestamp calculateExpiryDate(int expiryTimeInMinutes) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Timestamp(cal.getTime().getTime());
	}
	
}
