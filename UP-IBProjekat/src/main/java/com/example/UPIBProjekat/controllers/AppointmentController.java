package com.example.UPIBProjekat.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UPIBProjekat.model.User;
import com.example.UPIBProjekat.model.Appointment;
import com.example.UPIBProjekat.service.AppointmentService;

@RestController
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
		
	
	@GetMapping("/pregledi")
	public List<Appointment> list(){
		return appointmentService.listAll();
	}
	
	
	@PostMapping("/pregledi")
	public void add(@RequestBody Appointment pregled) {
		appointmentService.save(pregled);

	}
	
	
	@GetMapping("/pregledi/{id1}")
	public ResponseEntity<Appointment> get(@PathVariable Integer id1){
		try {
			Appointment pregled = appointmentService.get(id1);
			return new ResponseEntity<Appointment>(pregled, HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/pregledi/{id1}")
	public void update(@RequestBody Appointment pregled,
			@PathVariable Integer id) {
		
		appointmentService.save(pregled);
		
	}
	
	@DeleteMapping("/pregledi/{id}")
	public void delete(@PathVariable Integer id) {
		appointmentService.delete(id);
	}
	
}
