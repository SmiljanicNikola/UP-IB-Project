package com.example.UPIBProjekat.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UPIBProjekat.model.Clinic;
import com.example.UPIBProjekat.model.Role;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Integer>{
	

}
