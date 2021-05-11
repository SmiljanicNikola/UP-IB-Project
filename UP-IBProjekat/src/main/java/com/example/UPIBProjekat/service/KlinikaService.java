package com.example.UPIBProjekat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UPIBProjekat.Repository.KlinikaRepository;
import com.example.UPIBProjekat.model.Klinika;



@Service
public class KlinikaService {
	
	@Autowired
	private KlinikaRepository klinikaRepo;
	
	
	public List<Klinika> listAll(){
		return (ArrayList<Klinika>)klinikaRepo.findAll();
	}
	
	public void save(Klinika klinika) {
		klinikaRepo.save(klinika);
	}
	
	public Klinika get(Integer id) {
		return klinikaRepo.findById(id).get();
	}
	
	public void delete(Integer id) {
		klinikaRepo.deleteById(id);
	}
	
	

}
