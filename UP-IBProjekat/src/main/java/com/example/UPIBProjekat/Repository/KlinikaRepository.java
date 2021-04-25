package com.example.UPIBProjekat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UPIBProjekat.model.Klinika;

@Repository
public interface KlinikaRepository extends JpaRepository<Klinika, Integer>{

}
