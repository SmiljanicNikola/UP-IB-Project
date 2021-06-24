package com.example.UPIBProjekat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UPIBProjekat.Repository.PatientRepository;
import com.example.UPIBProjekat.model.Patient;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepo;
	
	
	public List<Patient> listAll(){
		return (ArrayList<Patient>)patientRepo.findAll();
	}
	
	public void save(Patient patient) {
		patientRepo.save(patient);
	}
	
	public Patient get(Integer id) {
		return patientRepo.findById(id).get();
	}
	
	public void delete(Integer id) {
		patientRepo.deleteById(id);
	}
	
	
}
