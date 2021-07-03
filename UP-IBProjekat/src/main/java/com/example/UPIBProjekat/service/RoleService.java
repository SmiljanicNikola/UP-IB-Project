package com.example.UPIBProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UPIBProjekat.Repository.RoleRepository;
import com.example.UPIBProjekat.model.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepo;
	
	
	public List<Role> listAll(){
		return roleRepo.findAll();
	}
	
	public Role get(Integer id) {
		return roleRepo.findById(id).get();
	}

}
