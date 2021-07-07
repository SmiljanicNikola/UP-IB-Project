package com.example.UPIBProjekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliniccentaradmins")
public class ClinicCentarAdministrator implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cliniccentaradmin_id", unique = true, nullable = false)
	private Integer id;
	
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	public ClinicCentarAdministrator(Integer id, User user) {
		super();
		this.id = id;
		this.user = user;
	}
	
	

	public ClinicCentarAdministrator() {
		super();
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    

}
