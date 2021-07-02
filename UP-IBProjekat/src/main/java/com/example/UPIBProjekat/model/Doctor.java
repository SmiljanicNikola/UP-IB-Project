package com.example.UPIBProjekat.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Optional;
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
@Table(name = "doctor")
public class Doctor implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="doctor_id", unique = true, nullable = false)
	private Integer id;
	
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;
    
    @ManyToOne//Brisem FetchType.LAZY
    @JoinColumn(name = "clinic_id", referencedColumnName = "clinic_id")
    private Clinic clinic;
    
    //@OneToMany(mappedBy= "doctor",fetch = FetchType.EAGER)//SAA OVIMEEEE
    //@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "doctor")
    @OneToMany(cascade= {ALL}, mappedBy="doctor",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Appointment> appointments = new HashSet<Appointment>();
    
    
    /*public void add(Appointment a) {
        if (a.getDoctor() != null)
            a.getDoctor().getAppointments().remove(a);
        a.setDoctor(this);
        getAppointments().add(a);
    }*/
	
	public Doctor() {
		
	}

	public User getUser() {
		return user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	


}
