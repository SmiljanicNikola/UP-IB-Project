package com.example.UPIBProjekat.payload;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignupRequest {
	
	@NotBlank
	private String firstname;
	
	@NotBlank
	private String lastname;

	@NotBlank
	@Email
    @Size(min = 3, max = 20)
    private String username;
	
	private String adress;
	
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
	
	@NotBlank
	private String city;
	
	
	@NotBlank
	private String country;
	
	
	@NotBlank
	private String phone;
	
	@NotBlank
	private boolean active;
	
	@NotBlank
	private Integer clinic;

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

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
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

	public Integer getClinic_id() {
		return clinic;
	}

	public void setClinic_id(Integer clinic) {
		this.clinic = clinic;
	}
	
	
  
    
    
    
   
    
}
