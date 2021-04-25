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

import com.example.UPIBProjekat.model.Korisnik;
import com.example.UPIBProjekat.service.KorisnikService;

@RestController
public class KorisnikController {
	@Autowired
	private KorisnikService korisnikService;
	
	@GetMapping("/korisnici")
	public List<Korisnik> list(){
		return korisnikService.listAll();
	}
	
	@PostMapping("/korisnici")
	public void add(@RequestBody Korisnik korisnik) {
		korisnikService.save(korisnik);

	}
	
	
	@GetMapping("/korisnici/{id}")
	public ResponseEntity<Korisnik> get(@PathVariable Integer id){
		try {
			Korisnik korisnik = korisnikService.get(id);
			return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Korisnik>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/korisnici/{id}")
	public ResponseEntity<?> update(@RequestBody Korisnik korisnik, 
			@PathVariable Integer id) {
		try {
			Korisnik existKorisnik = korisnikService.get(id);
			if(existKorisnik != null) {
				existKorisnik.setIme(korisnik.getIme());
				existKorisnik.setPrezime(korisnik.getPrezime());
				existKorisnik.setEmail(korisnik.getEmail());
				existKorisnik.setAdresa(korisnik.getAdresa());
				existKorisnik.setLozinka(korisnik.getLozinka());
				existKorisnik.setGrad(korisnik.getGrad());
				existKorisnik.setDrzava(korisnik.getDrzava());
				existKorisnik.setTelefon(korisnik.getTelefon());
				existKorisnik.setUloga(korisnik.getUloga());
				existKorisnik.setPrijavljen(korisnik.isPrijavljen());
				korisnikService.save(existKorisnik);
			}
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/korisnici/{id}")
	public void delete(@PathVariable Integer id) {
		korisnikService.delete(id);
	}
	
	
}