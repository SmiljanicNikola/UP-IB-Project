package com.example.UPIBProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UPIBProjekat.Repository.ClinicAdministratorRepository;
import com.example.UPIBProjekat.Repository.ClinicCentarAdministratorRepository;
import com.example.UPIBProjekat.model.ClinicAdministrator;
import com.example.UPIBProjekat.model.ClinicCentarAdministrator;

@Service
public class ClinicCentarAdministratorService {

	@Autowired
	private ClinicCentarAdministratorRepository clinicCentarAdminRepo;
	
	
	
	public ClinicCentarAdministrator save(ClinicCentarAdministrator clinicentarAdmin) {
		return clinicCentarAdminRepo.save(clinicentarAdmin);
	}
	
	
	public List<ClinicCentarAdministrator> listAll(){
		return clinicCentarAdminRepo.findAll();
	}
	
	
	public ClinicCentarAdministrator findOne(Integer id) {
		return clinicCentarAdminRepo.findById(id).orElse(null);
	}
	
	public void delete(Integer id) {
		clinicCentarAdminRepo.deleteById(id);
	}
	
	

	
}
