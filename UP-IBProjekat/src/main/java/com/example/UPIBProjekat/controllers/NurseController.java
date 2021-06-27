package com.example.UPIBProjekat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UPIBProjekat.model.Doctor;
import com.example.UPIBProjekat.model.Nurse;
import com.example.UPIBProjekat.service.DoctorService;
import com.example.UPIBProjekat.service.NurseService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class NurseController {
	
	@Autowired
	private NurseService nurseService;
		
	@GetMapping("/medicinskesestre")
	public List<Nurse> list(){
		return nurseService.listAll();
	}
	
	@PostMapping("/medicinskesestre")
	public void add(@RequestBody Nurse nurse) {
		nurseService.save(nurse);

	}
	
	@DeleteMapping("/medicinskesestre/{id}")
	public void delete(@PathVariable Integer id) {
		nurseService.delete(id);
	}

}
