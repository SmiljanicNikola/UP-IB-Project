package com.example.UPIBProjekat.model.dto;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.UPIBProjekat.model.Appointment;
import com.example.UPIBProjekat.model.Clinic;
import com.example.UPIBProjekat.model.Doctor;
import com.example.UPIBProjekat.model.User;

public class DoctorDTO {

	private Integer id;
	
	private UserDTO user;
    
    private ClinicDTO clinic;

	public DoctorDTO(Integer id, UserDTO user, ClinicDTO clinic) {
		super();
		this.id = id;
		this.user = user;
		this.clinic = clinic;
	}
    
	public DoctorDTO(Doctor doctor) {
		this(doctor.getId(), new UserDTO(doctor.getUser()), new ClinicDTO(doctor.getClinic()));
	}
	
    public DoctorDTO() {
    	
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public ClinicDTO getClinic() {
		return clinic;
	}

	public void setClinic(ClinicDTO clinic) {
		this.clinic = clinic;
	}
    
    
    
    
	
}
