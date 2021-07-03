package com.example.UPIBProjekat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UPIBProjekat.model.Role;
import com.example.UPIBProjekat.service.RoleService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping("/role")
	public List<Role> list(){
		return roleService.listAll();
	}
	
}
