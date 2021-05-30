package com.example.UPIBProjekat.model.dto;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.UPIBProjekat.model.Appointment;
import com.example.UPIBProjekat.model.Nurse;
import com.example.UPIBProjekat.model.User;

public class NurseDTO {

	private Integer id;
	
	private UserDTO user;

	
	public NurseDTO() {
		
	}
	
	
	public NurseDTO(Nurse nurse) {
		this(nurse.getId(), new UserDTO(nurse.getUser()));
	}
	
	public NurseDTO(Integer id, UserDTO user) {
		super();
		this.id = id;
		this.user = user;
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
	
  
	
	
}
