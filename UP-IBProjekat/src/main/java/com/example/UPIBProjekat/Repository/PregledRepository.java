package com.example.UPIBProjekat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UPIBProjekat.model.Pregled;

@Repository
public interface PregledRepository extends JpaRepository<Pregled, Integer> {

}
