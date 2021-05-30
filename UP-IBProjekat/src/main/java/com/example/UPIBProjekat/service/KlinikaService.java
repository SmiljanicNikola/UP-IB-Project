package com.example.UPIBProjekat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UPIBProjekat.Repository.ClinicRepository;
import com.example.UPIBProjekat.model.Clinic;



@Service
public class KlinikaService {
	
	@Autowired
	private ClinicRepository klinikaRepo;
	
	
	public List<Clinic> listAll(){
		return (ArrayList<Clinic>)klinikaRepo.findAll();
	}
	
	public void save(Clinic klinika) {
		klinikaRepo.save(klinika);
	}
	
	public Clinic get(Integer id) {
		return klinikaRepo.findById(id).get();
	}
	
	public void delete(Integer id) {
		klinikaRepo.deleteById(id);
	}
	
	

}
