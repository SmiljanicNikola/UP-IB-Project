package com.example.UPIBProjekat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Korisnik {
	private int id;
	private String ime;
	private String prezime;
	private String email;
	private String adresa;
	private String lozinka;
	private String grad;
	private String drzava;
	private String telefon;
	private String uloga;
	private boolean prijavljen;
	
	public Korisnik() {
		
	}

	public String getIme() {
		return ime;
	}
	

	


	public Korisnik(String ime, String prezime, String email, String adresa, String lozinka, String grad, String drzava,
			String telefon, String uloga, boolean prijavljen) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.adresa = adresa;
		this.lozinka = lozinka;
		this.grad = grad;
		this.drzava = drzava;
		this.telefon = telefon;
		this.uloga = uloga;
		this.prijavljen = prijavljen;
	}

	public Korisnik(int id, String ime, String prezime, String email, String adresa, String lozinka, String grad,
			String drzava, String telefon, String uloga, boolean prijavljen) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.adresa = adresa;
		this.lozinka = lozinka;
		this.grad = grad;
		this.drzava = drzava;
		this.telefon = telefon;
		this.uloga = uloga;
		this.prijavljen = prijavljen;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	


	

	public Korisnik(int id, String ime, String prezime, String email, String adresa, String lozinka, String grad,
			String drzava, String telefon, String uloga) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.adresa = adresa;
		this.lozinka = lozinka;
		this.grad = grad;
		this.drzava = drzava;
		this.telefon = telefon;
		this.uloga = uloga;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getUloga() {
		return uloga;
	}
	public void setUloga(String uloga) {
		this.uloga = uloga;
	}


	public boolean isPrijavljen() {
		return prijavljen;
	}


	public void setPrijavljen(boolean prijavljen) {
		this.prijavljen = prijavljen;
	}


	
}