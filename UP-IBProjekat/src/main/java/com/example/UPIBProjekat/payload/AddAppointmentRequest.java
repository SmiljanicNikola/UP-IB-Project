package com.example.UPIBProjekat.payload;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

public class AddAppointmentRequest {

	@NotBlank
	private LocalDateTime DateAndTime;
	
	@NotBlank
	private String appointmentLenght;
	
	@NotBlank
	private Integer doctor;
	
	@NotBlank
	private Integer nurse;
	
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

	

	public Integer getDoctor_Id() {
		return doctor;
	}

	public void setDoctor_Id(Integer doctor) {
		this.doctor = doctor;
	}

	public Integer getNurse_Id() {
		return nurse;
	}

	public void setNurse_Id(Integer nurse) {
		this.nurse = nurse;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	
}
