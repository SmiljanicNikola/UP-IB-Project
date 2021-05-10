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

import com.example.UPIBProjekat.model.Korisnik;
import com.example.UPIBProjekat.model.Pregled;
import com.example.UPIBProjekat.service.PregledService;

@RestController
public class PregledController {

	@Autowired
	private PregledService pregledService;
	
	
	private List<Pregled> pregledi = new ArrayList<>();

	
	
	@GetMapping("/pregledi")
	public List<Pregled> list(){
		return pregledService.listAll();
	}
	
	
	@PostMapping("/pregledi")
	public void add(@RequestBody Pregled pregled) {
		pregledService.save(pregled);

	}
	
	
	@GetMapping("/pregledi/{id1}")
	public ResponseEntity<Pregled> get(@PathVariable Integer id1){
		try {
			Pregled pregled = pregledService.get(id1);
			return new ResponseEntity<Pregled>(pregled, HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Pregled>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/pregledi/{id1}")
	public void update(@RequestBody Pregled pregled,
			@PathVariable Integer id) {
		
		pregledService.save(pregled);
		
	}
	
	@DeleteMapping("/pregledi/{id}")
	public void delete(@PathVariable Integer id) {
		pregledService.delete(id);
	}
	
}
