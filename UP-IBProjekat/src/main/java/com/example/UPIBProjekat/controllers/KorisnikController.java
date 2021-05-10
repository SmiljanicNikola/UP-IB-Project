package com.example.UPIBProjekat.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UPIBProjekat.model.Korisnik;
import com.example.UPIBProjekat.service.KorisnikService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class KorisnikController {
	
	
	@Autowired
	private KorisnikService korisnikService;
	
	
	private List<Korisnik> korisnici = new ArrayList<>();
	
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
	
	

	@PostMapping("/korisnici/login")
	@Consumes("MediaType.APPLICATION_JSON")
	@Produces("MediaType.APPLICATION_JSON")
		public ResponseEntity<Korisnik> login(@QueryParam(value="email") String email, @QueryParam(value="lozinka") String lozinka){
			//List<Korisnik> korisnici = new ArrayList<>();
			korisnici = korisnikService.listAll();
			for(Korisnik korisnik : korisnici) {
				if((korisnik.getEmail() == email) && (korisnik.getLozinka() == lozinka)) {
					return new ResponseEntity<Korisnik>(HttpStatus.OK);
				}
				else{
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
			
			return new ResponseEntity<Korisnik>(HttpStatus.OK);
			
		}
		

	@Consumes("MediaType.APPLICATION_JSON")
	@Produces("MediaType.APPLICATION_JSON")
	@PostMapping("/korisnici/register")
	public ResponseEntity<Korisnik> Register(@QueryParam("ime") String ime, 
											@QueryParam("prezime") String prezime,
											@QueryParam("email") String email,
											@QueryParam("adresa") String adresa,
											@QueryParam("lozinka") String lozinka,
											@QueryParam("grad") String grad,
											@QueryParam("drzava") String drzava,
											@QueryParam("telefon") String telefon){
		Korisnik k1 = new Korisnik(ime,prezime, email, adresa, lozinka, grad, drzava, telefon,"Pacijent");
		korisnikService.save(k1);
		return new ResponseEntity<Korisnik>(HttpStatus.OK);
		
	}
	
	
}