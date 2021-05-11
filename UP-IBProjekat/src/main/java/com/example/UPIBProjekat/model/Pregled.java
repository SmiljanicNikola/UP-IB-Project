package com.example.UPIBProjekat.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.print.attribute.standard.DateTimeAtCompleted;

@Table(name = "pregled")
@Entity(name="Pregled")
public class Pregled implements Serializable {
	
	//@Column(name = "pregled_id", unique = true, nullable = false)
	private int id;
			
	@Column(name = "datumIVreme", unique = false, nullable = false)
	private LocalDateTime datumIVreme;
	
	@Column(name = "trajanjePregleda", unique = false, nullable = false)
	private String trajanjePregleda;
	
	@ManyToOne
    @JoinColumn(name = "lekar_id", referencedColumnName = "lekar_id", nullable = false)
	private Lekar lekarId;
	
	@ManyToOne
	@JoinColumn(name = "medicinskaSestra_id", referencedColumnName = "medicinskaSestra_id", nullable = false)
	private MedicinskaSestra medicinskaSestraId;
	
	@Column(name = "cena", unique = false, nullable = false)
	private float cena;
	
	
	public Pregled() {
		
	}


	
	
	
	/*public Pregled(int id, LocalDateTime datumIVreme, String trajanjePregleda, Lekar lekarId,
			MedicinskaSestra medicinskaSestraId, float cena) {
		super();
		this.id = id;
		this.datumIVreme = datumIVreme;
		this.trajanjePregleda = trajanjePregleda;
		this.lekarId = lekarId;
		this.medicinskaSestraId = medicinskaSestraId;
		this.cena = cena;
	}*/




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDateTime getDatumIVreme() {
		return datumIVreme;
	}


	public void setDatumIVreme(LocalDateTime datumIVreme) {
		this.datumIVreme = datumIVreme;
	}


	public String getTrajanjePregleda() {
		return trajanjePregleda;
	}


	public void setTrajanjePregleda(String trajanjePregleda) {
		this.trajanjePregleda = trajanjePregleda;
	}


	public Lekar getLekarId() {
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


	public float getCena() {
		return cena;
	}


	public void setCena(float cena) {
		this.cena = cena;
	}

	
	
	
	
	
	
	
}
