package com.example.UPIBProjekat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UPIBProjekat.model.ClinicAdministrator;
import com.example.UPIBProjekat.service.ClinicAdministratorService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class ClinicAdministratorController {

	@Autowired
	private ClinicAdministratorService clinicAdminService;
	
	@GetMapping("/adminiKlinike")
	public List<ClinicAdministrator> list(){
		return clinicAdminService.listAll();
	}
	
}
