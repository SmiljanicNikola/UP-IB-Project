package com.example.UPIBProjekat.controllers;

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

import com.example.UPIBProjekat.model.Klinika;
import com.example.UPIBProjekat.service.KlinikaService;

@RestController
public class KlinikaController {
	
	@Autowired
	private KlinikaService klinikaservice;
	
	@GetMapping("/klinike")
	public List<Klinika> list(){
		return klinikaservice.listAll();
	}
	
	
	@PostMapping("/klinike")
	public void add(@RequestBody Klinika klinika) {
		klinikaservice.save(klinika);

	}
	
	@GetMapping("/klinike/{id}")
	public ResponseEntity<Klinika> get(@PathVariable Integer id){
		try {
			Klinika klinika = klinikaservice.get(id);
			return new ResponseEntity<Klinika>(klinika, HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Klinika>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/klinike/{id}")
	public ResponseEntity<?> update(@RequestBody Klinika klinika, 
			@PathVariable Integer id) {
		try {
			Klinika existKlinika = klinikaservice.get(id);
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
