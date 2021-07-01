package com.example.UPIBProjekat.model;

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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.example.UPIBProjekat.security.RefreshToken;


@Entity
@Table(name = "users")
public class User implements Serializable {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "firstname", unique = false, nullable = false, columnDefinition = "TEXT")
	private String firstname;
	
	@Column(name = "lastname", unique = false, nullable = false, columnDefinition = "TEXT")
	private String lastname;
	
	@Column(name = "email", unique = true, nullable = false, columnDefinition = "TEXT")
	private String username;
	
	@Column(name = "adress", unique = false, nullable = false, columnDefinition = "TEXT")
	private String adress;
	
	@Column(name = "password", unique = false, nullable = false)
	private String password;
	
	@Column(name = "city", unique = false, nullable = false, columnDefinition = "TEXT")
	private String city;
	
	@Column(name = "country", unique = false, nullable = false, columnDefinition = "TEXT")
	private String country;
	
	@Column(name = "phone", unique = false, nullable = false, columnDefinition = "TEXT")
	private String phone;
	
	@Column(name = "active", unique = false, nullable = false)
	private boolean active;
	
    @OneToOne(mappedBy = "user")
    private Doctor doctor;
    
    @OneToOne(mappedBy = "user")
    private Patient patient;
    
    @OneToOne(mappedBy = "user")
    private Nurse nurse;
    
    @OneToOne(mappedBy = "user")
    private RefreshToken refreshToken;
	
    @ManyToMany( cascade = CascadeType.MERGE)
    @Fetch(FetchMode.JOIN)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();
	
	public User() {
		
	}
	

	public User(String firstname, String lastname, String username, String adress, String password, String city,
			String country, String phone, boolean active) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.adress = adress;
		this.password = password;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.active = active;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	

	



	


	
}