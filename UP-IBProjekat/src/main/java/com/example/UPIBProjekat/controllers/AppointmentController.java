package com.example.UPIBProjekat.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UPIBProjekat.model.dto.AppointmentDTO;
import com.example.UPIBProjekat.payload.AddAppointmentRequest;
import com.example.UPIBProjekat.payload.MessageResponse;

import com.example.UPIBProjekat.Repository.DoctorRepository;
import com.example.UPIBProjekat.model.Appointment;
import com.example.UPIBProjekat.model.Doctor;
import com.example.UPIBProjekat.model.Nurse;
import com.example.UPIBProjekat.service.AppointmentService;
import com.example.UPIBProjekat.service.DoctorService;
import com.example.UPIBProjekat.service.NurseService;


@CrossOrigin(origins="http://localhost:3000")
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
	
	/*@PostMapping("/pregledi")
	public ResponseEntity<?> addAppointment(@Valid @RequestBody AddAppointmentRequest addAppointment) {
		
        Appointment appointment = new Appointment(addAppointment.getDateAndTime(), addAppointment.getAppointmentLenght(),addAppointment.getPrice());
        
        Doctor doctorr = doctorService.get(addAppointment.getDoctor_Id());
        appointment.setDoctor(doctorr);
        Nurse nursee = nurseService.get(addAppointment.getNurse_Id());
        appointment.setNurse(nursee);
        appointmentService.save(appointment);
        
		return ResponseEntity.ok(new MessageResponse("Uspesno dodat pregled!"));

    }
	*/
	 @PostMapping("/pregledi")
	 @Produces("MediaType.APPLICATION_JSON")
	    public ResponseEntity<AppointmentDTO> saveArtikal(@RequestBody AddAppointmentRequest addAppointment) {
	        Appointment appointment = new Appointment();
	        appointment.setDateAndTime(addAppointment.getDateAndTime());
	        appointment.setAppointmentLenght(addAppointment.getAppointmentLenght());
	        appointment.setDoctor(this.doctorService.findOne(addAppointment.getDoctorId()));
	        appointment.setNurse(this.nurseService.get(addAppointment.getNurseId()));
	        appointment.setPrice(addAppointment.getPrice());

	        appointment = appointmentService.save(appointment);
	        return new ResponseEntity<>(new AppointmentDTO(appointment), HttpStatus.CREATED);
	    }
	
	
	/*@PostMapping("/pregledi")
	public ResponseEntity<AppointmentDTO> saveAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setDateAndTime(appointmentDTO.getDateAndTime());
        appointment.setAppointmentLenght(appointmentDTO.getAppointmentLenght());
        appointment.setDoctor(doctorService.get(appointmentDTO.getId()));
        appointment.setNurse(nurseService.get(appointmentDTO.getId()));
        appointment.setPrice(appointmentDTO.getPrice());
       
        appointment = appointmentService.save(appointment);
        return new ResponseEntity<>(new AppointmentDTO(appointment), HttpStatus.CREATED);
   }
	*/
	
	@GetMapping("/pregledi/{id1}")
	public ResponseEntity<Appointment> get(@PathVariable Integer id1){
		try {
			Appointment pregled = appointmentService.findOne(id1);
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
	
	/*@DeleteMapping("/pregledi/{id}")
	public void delete(@PathVariable Integer id) {
		appointmentService.delete(id);
	}*/
	
	@DeleteMapping(value = "/pregledi/{id2}")
    public ResponseEntity<?> deleteAppointment(@PathVariable("id2") Integer id) {
        Appointment appointment = appointmentService.findOne(id);
        if (appointment != null) {
        	appointmentService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	
}
