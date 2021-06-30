package com.example.UPIBProjekat.model;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.print.attribute.standard.DateTimeAtCompleted;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "appointment_id", unique = true, nullable = false)
	private Integer id;
			
	@Column(name = "date_and_time", unique = false)
	private LocalDateTime DateAndTime;
	
	@Column(name = "appointment_lenght", unique = false)
	private String appointmentLenght;

	@ManyToOne(fetch = FetchType.LAZY)
	//@JsonIgnore
	//@ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
	private Doctor doctor;
	
	@ManyToOne
	//@ManyToOne
	@JoinColumn(name = "nurse_id", referencedColumnName = "nurse_id")
	private Nurse nurse;
	
	
	@Column(name = "price", unique = false)
	private float price;
	

	
	
	public Appointment() {
		
	}


	public Appointment(Integer id, LocalDateTime dateAndTime, String appointmentLenght, Doctor doctor, Nurse nurse,
			float price) {
		super();
		this.id = id;
		this.DateAndTime = dateAndTime;
		this.appointmentLenght = appointmentLenght;
		this.doctor = doctor;
		this.nurse = nurse;
		this.price = price;
	}
	
	

	public Appointment(LocalDateTime dateAndTime, String appointmentLenght, float price) {
		super();
		DateAndTime = dateAndTime;
		this.appointmentLenght = appointmentLenght;
		this.price = price;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDateAndTime() {
		return DateAndTime;
	}


	public void setDateAndTime(LocalDateTime dateAndTime) {
		DateAndTime = dateAndTime;
	}


	public String getAppointmentLenght() {
		return appointmentLenght;
	}


	public void setAppointmentLenght(String appointmentLenght) {
		this.appointmentLenght = appointmentLenght;
	}


	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	public Nurse getNurse() {
		return nurse;
	}


	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
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




	
	
	
	
	
	
	
	
}
