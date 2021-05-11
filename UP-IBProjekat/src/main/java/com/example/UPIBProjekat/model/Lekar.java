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
@Table(name = "lekar")
public class Lekar implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lekar_id", unique = true, nullable = false)
	private int lekar_id;
    
    @Column(name = "ime", unique = false, nullable = false, columnDefinition = "TEXT")
	private String ime;
    
    @Column(name = "prezimee", unique = false, nullable = false, columnDefinition = "TEXT")
	private String prezime;
	
	@OneToMany(cascade = {ALL}, fetch = LAZY, mappedBy = "lekar")
    private Set<Pregled> pregledi = new HashSet<Pregled>();
	
	public Lekar() {
		
	}


	public Lekar(int lekar_id, String ime, String prezime) {
		super();
		this.lekar_id = lekar_id;
		this.ime = ime;
		this.prezime = prezime;
		//this.pregledi = pregledi;
	}
// Set<Pregled> pregledi


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getLekar_id() {
		return lekar_id;
	}


	public void setLekar_id(int lekar_id) {
		this.lekar_id = lekar_id;
	}

	public String getIme() {
		return ime;
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
