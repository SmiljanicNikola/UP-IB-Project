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
	private LocalDateTime trajanjePregleda;
	//private Lekar lekarId;
	//private MedicinskaSestra medicinskaSestraId;
	private float cena;
	
	
	public Pregled() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDateTime getTrajanjePregleda() {
		return trajanjePregleda;
	}


	public void setTrajanjePregleda(LocalDateTime trajanjePregleda) {
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
	}
*/

	public float getCena() {
		return cena;
	}


	public void setCena(float cena) {
		this.cena = cena;
	}


	public Pregled(int id, LocalDateTime trajanjePregleda, Lekar lekarId, MedicinskaSestra medicinskaSestraId,
			float cena) {
		super();
		this.id = id;
		this.trajanjePregleda = trajanjePregleda;
		this.lekarId = lekarId;
		this.medicinskaSestraId = medicinskaSestraId;
		this.cena = cena;
	}

	
	
	
	
	
}
