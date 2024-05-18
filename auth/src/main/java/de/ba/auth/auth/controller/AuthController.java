package de.ba.auth.auth.controller;

import de.ba.auth.auth.dto.LoginDto;
import de.ba.auth.auth.dto.RegisterDto;
import de.ba.auth.auth.model.Role;
import de.ba.auth.auth.model.RoleName;
import de.ba.auth.auth.model.UserEntity;
import de.ba.auth.auth.repo.RoleRepository;
import de.ba.auth.auth.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
class AuthController {

	private AuthenticationManager authenticationManager;
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostMapping("login")
	public ResponseEntity<Void> login(@RequestBody LoginDto loginDto)
	{
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginDto.getUserName(),
						loginDto.getPassword()
				)
		);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		return ResponseEntity.status(HttpStatus.FOUND)
				.build();
	}


	@PostMapping(value = "/register")
	public ResponseEntity<Void> register( RegisterDto registerDto) {
		if (userRepository.existsByUsername(registerDto.getUsername())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		UserEntity user = new UserEntity();
		user.setUsername(registerDto.getUsername());
		user.setPassword(passwordEncoder.encode((registerDto.getPassword())));

		Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
				.orElseThrow(() -> new RuntimeException("User Role not set."));
		user.setRoles(Collections.singleton(userRole));

		System.out.println(user);
		userRepository.save(user);

		return ResponseEntity.status(HttpStatus.OK)
				.header(HttpHeaders.LOCATION, "/api/auth/login")
				.build();
	}
	
	
} // EoC