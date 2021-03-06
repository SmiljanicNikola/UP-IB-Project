package com.example.UPIBProjekat.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "nurse")
public class Nurse implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "nurse_id", unique = true, nullable = false)
	private Integer id;
	
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;
	
    @ManyToOne//Brisem FetchType.LAZY
    @JoinColumn(name = "clinic_id", referencedColumnName = "clinic_id")
    private Clinic clinic;
    
    
    //@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "nurse")
    //@OneToMany(cascade= {ALL}, mappedBy= "nurse",fetch = FetchType.EAGER) //SAAAA OVIMEEE
    @OneToMany(cascade= {ALL}, mappedBy= "nurse",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Appointment> appointments = new HashSet<Appointment>();
    
	
	public Nurse() {
		
	}
   public void add(Appointment a) {
        if (a.getNurse() != null)
            a.getNurse().getAppointments().remove(a);
        a.setNurse(this);
        getAppointments().add(a);
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


	public Set<Appointment> getAppointments() {
		return appointments;
	}


	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}
	public Clinic getClinic() {
		return clinic;
	}
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	


	

	
	
	
}
