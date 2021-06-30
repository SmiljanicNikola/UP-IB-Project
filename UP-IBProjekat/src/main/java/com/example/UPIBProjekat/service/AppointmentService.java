package com.example.UPIBProjekat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UPIBProjekat.Repository.AppointmentRepository;
import com.example.UPIBProjekat.model.Appointment;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepo;
	
	public List<Appointment> listAll(){
		return appointmentRepo.findAll();
	}
	
	public Appointment save(Appointment appointment) {
		return appointmentRepo.save(appointment);
	}
	
	public Appointment get(Integer id) {
		return appointmentRepo.findById(id).get();
	}
	
	public void delete(Integer id) {
		appointmentRepo.deleteById(id);
	}
	
}
