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

import com.example.UPIBProjekat.model.Clinic;
import com.example.UPIBProjekat.model.Doctor;
import com.example.UPIBProjekat.model.Patient;
import com.example.UPIBProjekat.service.DoctorService;
import com.example.UPIBProjekat.service.PatientService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
		
	@GetMapping("/doktori")
	public List<Doctor> list(){
		return doctorService.listAll();
	}
	
	@PostMapping("/doktori")
	public void add(@RequestBody Doctor doctor) {
		doctorService.save(doctor);

	}
	
	@GetMapping("/doktori/{id}")
	public ResponseEntity<Doctor> get(@PathVariable Integer id){
		try {
			Doctor doctor = doctorService.findOne(id);
			return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/doktori/{id}")
	public void delete(@PathVariable Integer id) {
		doctorService.delete(id);
	}
	
}
