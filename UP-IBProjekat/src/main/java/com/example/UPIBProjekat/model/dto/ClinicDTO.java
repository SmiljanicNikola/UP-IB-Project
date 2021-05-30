package com.example.UPIBProjekat.model.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.UPIBProjekat.model.Clinic;
import com.example.UPIBProjekat.model.Doctor;

public class ClinicDTO {

	
	private Integer id;
	
	private String naziv;
	
	private String adresa;
	
	private double prosecnaOcena;
	
	public ClinicDTO() {
		
	}

	public ClinicDTO(Clinic clinic) {
		this(clinic.getId(), clinic.getNaziv(), clinic.getAdresa(), clinic.getProsecnaOcena());
	}
	
	public ClinicDTO(Integer id, String naziv, String adresa, double prosecnaOcena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.prosecnaOcena = prosecnaOcena;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	
	

	
	
}
