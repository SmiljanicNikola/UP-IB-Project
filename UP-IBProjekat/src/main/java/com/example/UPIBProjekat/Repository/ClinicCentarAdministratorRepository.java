package com.example.UPIBProjekat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UPIBProjekat.model.ClinicCentarAdministrator;

@Repository
public interface ClinicCentarAdministratorRepository extends JpaRepository<ClinicCentarAdministrator, Integer> {

}
