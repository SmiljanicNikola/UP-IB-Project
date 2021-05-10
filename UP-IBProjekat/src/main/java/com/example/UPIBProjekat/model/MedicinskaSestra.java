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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicinskasestra")
public class MedicinskaSestra implements Serializable {

	@Column(name = "medicinskaSestra_id", unique = true, nullable = false)
	private int id;
	
    @Column(name = "ime", unique = false, nullable = false, columnDefinition = "TEXT")
	private String ime;
    
    @Column(name = "ime", unique = false, nullable = false, columnDefinition = "TEXT")
	private String prezime;
	
	@OneToOne(cascade = {ALL}, fetch = LAZY, mappedBy = "medicinskasestra")
    private Set<Pregled> pregledi = new HashSet<Pregled>();
	
	
	public MedicinskaSestra() {
		
	}


	public MedicinskaSestra(int id, String ime, String prezime) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getIme() {
		return ime;
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
	
	
	
	
}
