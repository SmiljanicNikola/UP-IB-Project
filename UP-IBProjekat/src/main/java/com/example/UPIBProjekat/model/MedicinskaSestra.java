package com.example.UPIBProjekat.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicinskasestra")
public class MedicinskaSestra implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "medicinskaSestra_id", unique = true, nullable = false)
	private int medicinskaSestra_id;
	
    @Column(name = "ime", unique = false, nullable = false, columnDefinition = "TEXT")
	private String ime;
    
    @Column(name = "ime", unique = false, nullable = false, columnDefinition = "TEXT")
	private String prezime;
	
	@OneToMany(cascade = {ALL}, fetch = LAZY, mappedBy = "medicinskasestra")
    private Set<Pregled> pregledi = new HashSet<Pregled>();
	
	
	public MedicinskaSestra() {
		
	}


	public MedicinskaSestra(int medicinskaSestra_id, String ime, String prezime) {
		super();
		this.medicinskaSestra_id = medicinskaSestra_id;
		this.ime = ime;
		this.prezime = prezime;
	}

	

	public String getIme() {
		return ime;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getMedicinskaSestra_id() {
		return medicinskaSestra_id;
	}


	public void setMedicinskaSestra_id(int medicinskaSestra_id) {
		this.medicinskaSestra_id = medicinskaSestra_id;
	}


	/*public Set<Pregled> getPregledi() {
		return pregledi;
	}


	public void setPregledi(Set<Pregled> pregledi) {
		this.pregledi = pregledi;
	}*/


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	
	
	
}
