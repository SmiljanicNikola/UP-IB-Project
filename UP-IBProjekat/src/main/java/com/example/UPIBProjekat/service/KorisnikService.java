package com.example.UPIBProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UPIBProjekat.Repository.KorisnikRepository;
import com.example.UPIBProjekat.model.Korisnik;

@Service
public class KorisnikService {
	
	@Autowired
	private KorisnikRepository korisnikRepo;
	
	
	public List<Korisnik> listAll(){
		return korisnikRepo.findAll();
	}
	
	public void save(Korisnik korisnik) {
		korisnikRepo.save(korisnik);
	}
	
	public Korisnik get(Integer id) {
		return korisnikRepo.findById(id).get();
	}
	
	public void delete(Integer id) {
		korisnikRepo.deleteById(id);
	}
}