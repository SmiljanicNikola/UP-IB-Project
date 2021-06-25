package com.example.UPIBProjekat.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UPIBProjekat.model.dto.AppointmentDTO;
import com.example.UPIBProjekat.model.Appointment;
import com.example.UPIBProjekat.service.AppointmentService;
import com.example.UPIBProjekat.service.DoctorService;
import com.example.UPIBProjekat.service.NurseService;




@RestController
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private NurseService nurseService;
	
	@GetMapping("/pregledi")
	public List<Appointment> list(){
		return appointmentService.listAll();
	}
	
	
	@PostMapping("/pregledi")
	public void add(@RequestBody Appointment pregled) {
		appointmentService.save(pregled);

	}
	
	/*@PostMapping("/pregledi")
	@Consumes("MediaType.APPLICATION_JSON")
	@Produces("MediaType.APPLICATION_JSON")
	public ResponseEntity<AppointmentDTO> saveAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setDateAndTime(appointmentDTO.getDateAndTime());
        appointment.setAppointmentLenght(appointmentDTO.getAppointmentLenght());
        appointment.setDoctor(doctorService.get(appointmentDTO.getId()));
        appointment.setNurse(nurseService.get(appointmentDTO.getId()));
        appointment.setPrice(appointmentDTO.getPrice());
       
        appointment = appointmentService.save(appointment);
        return new ResponseEntity<>(new AppointmentDTO(appointment), HttpStatus.CREATED);
   }*/
	
	
	@GetMapping("/pregledi/{id1}")
	public ResponseEntity<Appointment> get(@PathVariable Integer id1){
		try {
			Appointment pregled = appointmentService.get(id1);
			return new ResponseEntity<Appointment>(pregled, HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/pregledi/{id1}")
	public void update(@RequestBody Appointment pregled,
			@PathVariable Integer id) {
		
		appointmentService.save(pregled);
		
	}
	
	@DeleteMapping("/pregledi/{id}")
	public void delete(@PathVariable Integer id) {
		appointmentService.delete(id);
	}
	
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable("id") Integer id) {
        Appointment appointment = appointmentService.get(id);
        if (appointment != null) {
        	appointmentService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	
}
