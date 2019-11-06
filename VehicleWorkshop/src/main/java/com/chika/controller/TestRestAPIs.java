package com.chika.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {
	
	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('CUSTOMER') or hasRole('CUSTOMER')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/api/test/worker")
	@PreAuthorize("hasRole('WORKER') or hasRole('WORKER')")
	public String projectManagementAccess() {
		return ">>> Worker Board";
	}
	
	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}
}