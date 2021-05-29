package com.example.UPIBProjekat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.UPIBProjekat.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "SELECT u FROM User u WHERE u.username = :username")
	User getUserByUsername(@Param("username") String username);

	
	User findByUsername(String username);
	
	Boolean existsByUsername(String username);

}
