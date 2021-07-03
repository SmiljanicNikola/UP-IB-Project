package com.example.UPIBProjekat.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UPIBProjekat.model.Patient;
import com.example.UPIBProjekat.service.PatientService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class PatientController {

	@Autowired
	private PatientService patientService;
		
	@GetMapping("/pacijenti")
	public List<Patient> list(){
		return patientService.listAll();
	}
	
	@GetMapping("/pacijenti/{id}")
	public ResponseEntity<Patient> get(@PathVariable Integer id){
		try {
			Patient patient = patientService.get(id);
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
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
