package com.example.UPIBProjekat.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UPIBProjekat.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByName(String name);

}
