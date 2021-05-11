package com.example.UPIBProjekat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UPIBProjekat.model.MedicinskaSestra;

@Repository
public interface MedicinskaSestraRepository extends JpaRepository<MedicinskaSestra, Integer> {

}
