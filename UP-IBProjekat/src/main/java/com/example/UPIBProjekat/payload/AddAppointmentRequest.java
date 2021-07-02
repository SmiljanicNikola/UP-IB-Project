package com.example.UPIBProjekat.payload;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

public class AddAppointmentRequest {

	private Integer id;
	@NotBlank
	private LocalDateTime DateAndTime;
	
	@NotBlank
	private String appointmentLenght;
	
	@NotBlank
	private Integer doctorId;
	
	@NotBlank
	private Integer nurseId;
	
	@NotBlank
	private float price;

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

	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getNurseId() {
		return nurseId;
	}

	public void setNurseId(Integer nurseId) {
		this.nurseId = nurseId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	
}
