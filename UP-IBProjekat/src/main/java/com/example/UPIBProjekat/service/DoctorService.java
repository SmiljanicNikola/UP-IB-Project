package com.example.UPIBProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UPIBProjekat.Repository.AppointmentRepository;
import com.example.UPIBProjekat.Repository.DoctorRepository;
import com.example.UPIBProjekat.model.Appointment;
import com.example.UPIBProjekat.model.Doctor;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepo;
	
	public List<Doctor> listAll(){
		return doctorRepo.findAll();
	}
	
	public Doctor save(Doctor doctor) {
		return doctorRepo.save(doctor);
	}
	
	public Doctor findOne(Integer id) {
		return doctorRepo.findById(id).orElse(null);
	}
	
	public void delete(Integer id) {
		doctorRepo.deleteById(id);
	}
	
}
