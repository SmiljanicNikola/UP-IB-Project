package com.example.UPIBProjekat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UPIBProjekat.model.Nurse;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Integer> {

}
