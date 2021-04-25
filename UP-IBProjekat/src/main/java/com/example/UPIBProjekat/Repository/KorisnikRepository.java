package com.example.UPIBProjekat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UPIBProjekat.model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {

}
