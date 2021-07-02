package com.example.UPIBProjekat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UPIBProjekat.model.ClinicAdministrator;

@Repository
public interface ClinicAdministratorRepository extends JpaRepository<ClinicAdministrator, Integer> {

}
