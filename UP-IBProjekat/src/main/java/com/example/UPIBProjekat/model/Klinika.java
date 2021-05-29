package com.example.UPIBProjekat.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clinics")
public class Klinika {
	
	@Id
	private int id;
	private String naziv;
	private String adresa;
	private float prosecnaOcena;
	
//	@OneToMany(mappedBy="klinika", cascade=CascadeType.ALL)
//	private List<Lekar>	lekari;

	public Klinika(int id, String naziv, String adresa, float prosecnaOcena) {
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.prosecnaOcena = prosecnaOcena;
//		this.lekari = lekari;
	}
	

	public Klinika() {
}


	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public float getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(float prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

//	public List<Lekar> getLekari() {
//		return lekari;
//	}
//
//	public void setLekari(List<Lekar> lekari) {
//		this.lekari = lekari;
//	}
	
	

}
