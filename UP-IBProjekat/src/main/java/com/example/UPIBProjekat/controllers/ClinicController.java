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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UPIBProjekat.model.Clinic;
import com.example.UPIBProjekat.service.ClinicService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class ClinicController {
	
	@Autowired
	private ClinicService klinikaservice;
	
	@GetMapping("/klinike")
	public List<Clinic> list(){
		return klinikaservice.listAll();
	}
	
	
	@PostMapping("/klinike")
	public void add(@RequestBody Clinic klinika) {
		klinikaservice.save(klinika);

	}
	
	@GetMapping("/klinike/{id}")
	public ResponseEntity<Clinic> get(@PathVariable Integer id){
		try {
			Clinic klinika = klinikaservice.get(id);
			return new ResponseEntity<Clinic>(klinika, HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Clinic>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/klinike/{id}")
	public ResponseEntity<?> update(@RequestBody Clinic klinika, 
			@PathVariable Integer id) {
		try {
			Clinic existKlinika = klinikaservice.get(id);
			if(existKlinika != null) {
				existKlinika.setNaziv(klinika.getNaziv());
				existKlinika.setAdresa(klinika.getAdresa());
				existKlinika.setProsecnaOcena(klinika.getProsecnaOcena());
				klinikaservice.save(existKlinika);
			}

		return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/klinike/{id}")
	public void delete(@PathVariable Integer id) {
		klinikaservice.delete(id);
	}

}
