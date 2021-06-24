package com.example.UPIBProjekat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UPIBProjekat.model.Patient;
import com.example.UPIBProjekat.model.User;
import com.example.UPIBProjekat.service.PatientService;
import com.example.UPIBProjekat.service.UserService;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;
		
	@GetMapping("/pacijenti")
	public List<Patient> list(){
		return patientService.listAll();
	}
	
	@PostMapping("/pacijenti")
	public void add(@RequestBody Patient patient) {
		patientService.save(patient);

	}
	
	@DeleteMapping("/pacijenti/{id}")
	public void delete(@PathVariable Integer id) {
		patientService.delete(id);
	}
	
	
}
