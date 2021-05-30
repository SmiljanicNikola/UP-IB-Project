package com.example.UPIBProjekat.model.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.UPIBProjekat.model.Appointment;
import com.example.UPIBProjekat.model.Doctor;
import com.example.UPIBProjekat.model.Nurse;

public class AppointmentDTO {

	private Integer id;
	
	private LocalDateTime DateAndTime;
	
	private String appointmentLenght;
	
	private DoctorDTO doctor;
	
	private NurseDTO nurse;
	
	private float price;
	
	public AppointmentDTO() {
		
	}

	public AppointmentDTO(Appointment appointment) {
		this(appointment.getId(), appointment.getDateAndTime(), appointment.getAppointmentLenght(), new DoctorDTO(appointment.getDoctor()), 
				new NurseDTO(appointment.getNurse()), appointment.getPrice());
	}
	
	public AppointmentDTO(Integer id, LocalDateTime dateAndTime, String appointmentLenght, DoctorDTO doctor,
			NurseDTO nurse, float price) {
		super();
		this.id = id;
		this.DateAndTime = dateAndTime;
		this.appointmentLenght = appointmentLenght;
		this.doctor = doctor;
		this.nurse = nurse;
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

	public DoctorDTO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDTO doctor) {
		this.doctor = doctor;
	}

	public NurseDTO getNurse() {
		return nurse;
	}

	public void setNurse(NurseDTO nurse) {
		this.nurse = nurse;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	
	
}
