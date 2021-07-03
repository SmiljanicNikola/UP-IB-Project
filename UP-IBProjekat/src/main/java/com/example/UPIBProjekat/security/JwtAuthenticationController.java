package com.example.UPIBProjekat.security;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UPIBProjekat.Repository.ClinicRepository;
import com.example.UPIBProjekat.Repository.DoctorRepository;
import com.example.UPIBProjekat.Repository.NurseRepository;
import com.example.UPIBProjekat.Repository.PatientRepository;
import com.example.UPIBProjekat.Repository.RoleRepository;
import com.example.UPIBProjekat.Repository.UserRepository;
import com.example.UPIBProjekat.model.Clinic;
import com.example.UPIBProjekat.model.ClinicAdministrator;
import com.example.UPIBProjekat.model.Doctor;
import com.example.UPIBProjekat.model.Nurse;
import com.example.UPIBProjekat.model.Patient;
import com.example.UPIBProjekat.model.Role;
import com.example.UPIBProjekat.model.User;
import com.example.UPIBProjekat.payload.LoginRequest;
import com.example.UPIBProjekat.payload.MessageResponse;
import com.example.UPIBProjekat.payload.PatientSignupRequest;
import com.example.UPIBProjekat.payload.SignupRequest;
import com.example.UPIBProjekat.service.ClinicAdministratorService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/auth")
public class JwtAuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTUtil jwtTokenUtil;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private NurseRepository nurseRepository;
	
	@Autowired
	private ClinicRepository clinicRepository;
	
	@Autowired
	private RefreshTokenService refreshTokenService;
	
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private ClinicAdministratorService clinicAdminService;
	
	@Autowired
	PasswordEncoder encoder;

	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		MyUserDetails userDetails =  (MyUserDetails) authentication.getPrincipal();
		
		String jwt = jwtTokenUtil.generateToken(userDetails);
		

		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());
		
		
		return ResponseEntity.ok(new JWTResponse(jwt, 
				 userDetails.getId(), 
				 userDetails.getUsername(), 
				 roles,
				refreshToken.getToken(),
				"Bearer"));
}
	
	@PostMapping("doctor/signup")
	public ResponseEntity<?> registerDoctor(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		
		System.out.println("BLAAAAAAA");

		User user = new User(signUpRequest.getFirstname(), signUpRequest.getLastname(), signUpRequest.getUsername(), signUpRequest.getAdress(), encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getCity(), signUpRequest.getCountry(), signUpRequest.getPhone(), signUpRequest.isActive() == true);
		
		Set<Role> roles = new HashSet<>();
		
		Role userRole = roleRepository.findByName("LEKAR")
		.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);

		user.setRoles(roles);

		userRepository.save(user);
		
		Doctor doctor = new Doctor();
		doctor.setUser(user);
		doctor.setClinic(clinicRepository.getOne(signUpRequest.getClinic_id()));
		doctorRepository.save(doctor);

		

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	@PostMapping("clinicadmin/signup")
	public ResponseEntity<?> registerClinicAdmin(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		
		User user = new User(signUpRequest.getFirstname(), signUpRequest.getLastname(), signUpRequest.getUsername(), signUpRequest.getAdress(), encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getCity(), signUpRequest.getCountry(), signUpRequest.getPhone(), signUpRequest.isActive() == true);
		
		Set<Role> roles = new HashSet<>();
		
		Role userRole = roleRepository.findByName("ADMINISTRATOR KLINIKE")
		.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);

		user.setRoles(roles);

		userRepository.save(user);
		
		ClinicAdministrator clinicAdmin = new ClinicAdministrator();
		clinicAdmin.setUser(user);
		clinicAdmin.setClinic(clinicRepository.getOne(signUpRequest.getClinic_id()));
		clinicAdminService.save(clinicAdmin);

		

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	@PostMapping("nurse/signup")
	public ResponseEntity<?> registerNurse(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}


		User user = new User(signUpRequest.getFirstname(), signUpRequest.getLastname(), signUpRequest.getUsername(), signUpRequest.getAdress(), encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getCity(), signUpRequest.getCountry(), signUpRequest.getPhone(), signUpRequest.isActive() == true);
		
		Set<Role> roles = new HashSet<>();
		
		Role userRole = roleRepository.findByName("MEDICINSKA SESTRA")
		.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);

		user.setRoles(roles);

		userRepository.save(user);
		
		Nurse nurse = new Nurse();
		nurse.setUser(user);
		nurseRepository.save(nurse);

		

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	

	@PostMapping("patient/signup")
	public ResponseEntity<?> registerPatient(@Valid @RequestBody PatientSignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		


		User user = new User(signUpRequest.getFirstname(), signUpRequest.getLastname(), signUpRequest.getUsername(), signUpRequest.getAdress(), encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getCity(), signUpRequest.getCountry(), signUpRequest.getPhone(), signUpRequest.isActive() == true);
		Set<Role> roles = new HashSet<>();
		
		
		Role userRole = roleRepository.findByName("PACIJENT")
		.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		
		user.setRoles(roles);

		userRepository.save(user);
		
		Patient patient = new Patient(signUpRequest.getLbo());
		patient.setUser(user);
		System.out.println("BLAA" + signUpRequest.getLbo());
		patientRepository.save(patient);
		System.out.println("BLa");
		

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/signup")
//	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//			return ResponseEntity
//					.badRequest()
//					.body(new MessageResponse("Error: Username is already taken!"));
//		}
//
//
//		User user = new User(signUpRequest.getUsername(), signUpRequest.getFirstname(), signUpRequest.getLastname(), encoder.encode(signUpRequest.getPassword()), signUpRequest.isBlocked() == true);
//		
//		Set<String> strRoles = signUpRequest.getRole();
//		Set<Role> roles = new HashSet<>();
//
//		if (strRoles == null) {
//			
//			System.out.println("NEMA ROLE");
//			
//		} else {
//			strRoles.forEach(role -> {
//				switch (role) {
//				case "admin":
//					Role adminRole = roleRepository.findByName("ADMIN")
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(adminRole);
//
//					break;
//				case "mod":
//					Role modRole = roleRepository.findByName("SALESMEN")
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(modRole);
//
//					break;
//				default:
//					Role userRole = roleRepository.findByName("BUYER")
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(userRole);
//				}
//			});
//		}
//
//		user.setRoles(roles);
//		userRepository.save(user);
//
//		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//	}

}



