package com.example.UPIBProjekat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UPIBProjekat.Repository.PregledRepository;
import com.example.UPIBProjekat.model.Pregled;

@Service
public class PregledService {

	@Autowired
	private PregledRepository pregledRepo;
	
	public ArrayList<Pregled> listAll(){
		return (ArrayList<Pregled>) pregledRepo.findAll();
	}
	
	public void save(Pregled pregled) {
		pregledRepo.save(pregled);
	}
	
	public Pregled get(Integer id) {
		return pregledRepo.findById(id).get();
	}
	
	public void delete(Integer id) {
		pregledRepo.deleteById(id);
	}
	
}
