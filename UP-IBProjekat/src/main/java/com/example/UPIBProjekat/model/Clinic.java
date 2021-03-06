package com.example.UPIBProjekat.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="clinics")
public class Clinic implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="clinic_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name="name", unique = false, nullable = false)
	private String naziv;
	
	@Column(name="adress", unique = false, nullable = false)
	private String adresa;
	
	@Column(name="avg_rate", unique = false, nullable = false)
	private double prosecnaOcena;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL},orphanRemoval = true,mappedBy = "clinic")
	@JsonIgnore
    private Set<Doctor> doctors = new HashSet<Doctor>();
	
	@OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL},orphanRemoval = true,mappedBy = "clinic")
	@JsonIgnore
    private Set<Nurse> nurses = new HashSet<Nurse>();
	
	@OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL},orphanRemoval = true,mappedBy = "clinic")
	@JsonIgnore
    private Set<ClinicAdministrator> clinicadmins = new HashSet<ClinicAdministrator>();

	public Clinic(String naziv, String adresa, double prosecnaOcena) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.prosecnaOcena = prosecnaOcena;
	}
	

	public Clinic() {
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


	public Set<Doctor> getDoctors() {
		return doctors;
	}


	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}


	public Set<ClinicAdministrator> getClinicadmins() {
		return clinicadmins;
	}


	public void setClinicadmins(Set<ClinicAdministrator> clinicadmins) {
		this.clinicadmins = clinicadmins;
	}


	public Set<Nurse> getNurses() {
		return nurses;
	}


	public void setNurses(Set<Nurse> nurses) {
		this.nurses = nurses;
	}
	
	


	
	

}
