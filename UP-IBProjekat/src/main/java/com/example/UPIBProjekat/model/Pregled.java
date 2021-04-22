package com.example.UPIBProjekat.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.print.attribute.standard.DateTimeAtCompleted;

@Entity
public class Pregled {

	private int id;
	private String trajanjePregleda;
	//private Lekar lekarId;
	//private MedicinskaSestra medicinskaSestraId;
	private float cena;
	
	
	public Pregled() {
		
	}

	/*public Pregled(Integer id, LocalDateTime datumIVremePregleda, String trajanjePregleda, Lekar lekarId,
			MedicinskaSestra medicinskaSestraId, float cena) {
		super();
		this.id = id;
		this.datumIVremePregleda = datumIVremePregleda;
		this.trajanjePregleda = trajanjePregleda;
		//this.lekarId = lekarId;
		//this.medicinskaSestraId = medicinskaSestraId;
		this.cena = cena;
	}*/


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public Pregled(int id, String trajanjePregleda, float cena) {
		super();
		this.id = id;
		this.trajanjePregleda = trajanjePregleda;
		this.cena = cena;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getTrajanjePregleda() {
		return trajanjePregleda;
	}


	public void setTrajanjePregleda(String trajanjePregleda) {
		this.trajanjePregleda = trajanjePregleda;
	}


	/*public Lekar getLekarId() {
		return lekarId;
	}

	public void setLekarId(Lekar lekarId) {
		this.lekarId = lekarId;
	}


	public MedicinskaSestra getMedicinskaSestraId() {
		return medicinskaSestraId;
	}


	public void setMedicinskaSestraId(MedicinskaSestra medicinskaSestraId) {
		this.medicinskaSestraId = medicinskaSestraId;
	}*/


	public float getCena() {
		return cena;
	}


	public void setCena(float cena) {
		this.cena = cena;
	}
	
	
	
	
	
	
}
