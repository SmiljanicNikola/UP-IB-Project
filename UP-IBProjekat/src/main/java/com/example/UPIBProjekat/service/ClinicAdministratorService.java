package com.example.UPIBProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UPIBProjekat.Repository.ClinicAdministratorRepository;
import com.example.UPIBProjekat.Repository.DoctorRepository;
import com.example.UPIBProjekat.model.ClinicAdministrator;
import com.example.UPIBProjekat.model.Doctor;

@Service
public class ClinicAdministratorService {
	
	@Autowired
	private ClinicAdministratorRepository clinicAdminRepo;
	
	public List<ClinicAdministrator> listAll(){
		return clinicAdminRepo.findAll();
	}
	
	public ClinicAdministrator save(ClinicAdministrator clinicAdmin) {
		return clinicAdminRepo.save(clinicAdmin);
	}
	
	public ClinicAdministrator findOne(Integer id) {
		return clinicAdminRepo.findById(id).orElse(null);
	}
	
	public void delete(Integer id) {
		clinicAdminRepo.deleteById(id);
	}
	
}
