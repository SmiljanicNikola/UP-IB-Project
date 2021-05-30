package com.example.UPIBProjekat.model.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.UPIBProjekat.model.User;

public class UserDTO {

	
	private Integer id;
	
	private String firstname;
	
	private String lastname;
	
	private String username;
	
	private String adress;
	
	private String password;
	
	private String city;
	
	private String country;
	
	private String phone;
	
	private boolean active;
	
	
	public UserDTO() {
		
	}

	public UserDTO(User user) {
		this(user.getId(), user.getFirstname(), user.getLastname(), user.getUsername(), user.getAdress(), user.getPassword(),
				user.getCity(), user.getCountry(), user.getPhone(), user.isActive());
	}
	
	public UserDTO(Integer id, String firstname, String lastname, String username, String adress, String password,
			String city, String country, String phone, boolean active) {
		super();
		this.id = id;
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
	
	
	
	
	
}
