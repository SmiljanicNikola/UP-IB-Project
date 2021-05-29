package com.example.UPIBProjekat.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.ws.rs.Consumes;
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

import com.example.UPIBProjekat.model.User;
import com.example.UPIBProjekat.service.KorisnikService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class KorisnikController {
	
	
	@Autowired
	private KorisnikService korisnikService;
	
	
	private List<User> korisnici = new ArrayList<>();
	
	@GetMapping("/korisnici")
	public List<User> list(){
		return korisnikService.listAll();
	}
	
	@PostMapping("/korisnici")
	public void add(@RequestBody User korisnik) {
		korisnikService.save(korisnik);

	}
	
	
	
	
	@GetMapping("/korisnici/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id){
		try {
			User korisnik = korisnikService.get(id);
			return new ResponseEntity<User>(korisnik, HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/korisnici/{id}")
	public ResponseEntity<?> update(@RequestBody User korisnik, 
			@PathVariable Integer id) {
		try {
			User existKorisnik = korisnikService.get(id);
			if(existKorisnik != null) {
				existKorisnik.setFirstname(korisnik.getFirstname());
				existKorisnik.setLastname(korisnik.getLastname());
				existKorisnik.setUsername(korisnik.getUsername());
				existKorisnik.setAdress(korisnik.getAdress());
				existKorisnik.setPassword(korisnik.getPassword());
				existKorisnik.setCity(korisnik.getCity());
				existKorisnik.setCountry(korisnik.getCountry());
				existKorisnik.setPhone(korisnik.getPhone());
				existKorisnik.setActive(korisnik.isActive());
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
	
	

//	@PostMapping("/korisnici/login")
//	@Consumes("MediaType.APPLICATION_JSON")
//	@Produces("MediaType.APPLICATION_JSON")
//		public ResponseEntity<User> login(@QueryParam(value="email") String email, @QueryParam(value="lozinka") String lozinka){
//			//List<Korisnik> korisnici = new ArrayList<>();
//			korisnici = korisnikService.listAll();
//			for(User korisnik : korisnici) {
//				if((korisnik.getEmail() == email) && (korisnik.getPassword() == lozinka)) {
//					return new ResponseEntity<User>(HttpStatus.OK);
//				}
//				else{
//					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//				}
//			}
//			
//			return new ResponseEntity<User>(HttpStatus.OK);
//			
//		}
//		
//
//	@Consumes("MediaType.APPLICATION_JSON")
//	@Produces("MediaType.APPLICATION_JSON")
//	@PostMapping("/korisnici/register")
//	public ResponseEntity<User> Register(@QueryParam("ime") String ime, 
//											@QueryParam("prezime") String prezime,
//											@QueryParam("email") String email,
//											@QueryParam("adresa") String adresa,
//											@QueryParam("lozinka") String lozinka,
//											@QueryParam("grad") String grad,
//											@QueryParam("drzava") String drzava,
//											@QueryParam("telefon") String telefon){
//		User k1 = new User(ime,prezime, email, adresa, lozinka, grad, drzava, telefon,"Pacijent");
//		korisnikService.save(k1);
//		return new ResponseEntity<User>(HttpStatus.OK);
//		
//	}
	
	
}