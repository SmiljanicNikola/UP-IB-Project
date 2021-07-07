package com.example.UPIBProjekat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UPIBProjekat.Repository.UserRepository;
import com.example.UPIBProjekat.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository korisnikRepo;
	
	
	public List<User> listAll(){
		return korisnikRepo.findAll();
	}
	
	
	
	public void save(User korisnik) {
		korisnikRepo.save(korisnik);
	}
	
	public User get(Integer id) {
		return korisnikRepo.findById(id).orElse(null);
	}
	
	public User get(String username) {
		return korisnikRepo.findByUsername(username);
	}
	
	public void delete(Integer id) {
		korisnikRepo.deleteById(id);
	}
}