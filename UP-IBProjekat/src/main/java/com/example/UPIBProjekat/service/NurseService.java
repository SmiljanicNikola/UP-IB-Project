package com.example.UPIBProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UPIBProjekat.Repository.DoctorRepository;
import com.example.UPIBProjekat.Repository.NurseRepository;
import com.example.UPIBProjekat.model.Doctor;
import com.example.UPIBProjekat.model.Nurse;

@Service
public class NurseService {

	@Autowired
	private NurseRepository nurseRepo;
	
	public List<Nurse> listAll(){
		return nurseRepo.findAll();
	}
	
	public Nurse save(Nurse nurse) {
		return nurseRepo.save(nurse);
	}
	
	public Nurse get(Integer id) {
		return nurseRepo.findById(id).get();
	}
	
	public void delete(Integer id) {
		nurseRepo.deleteById(id);
	}
	
}
