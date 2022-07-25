package com.thales.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thales.commerce.model.Administration;
import com.thales.commerce.service.AdministrationService;

@RestController
@RequestMapping("/administration")
public class AdministrationController {
	@Autowired
	private AdministrationService adminService;

	@CrossOrigin(origins = "*")
	@GetMapping("")
	public List<Administration> findAll() {
		return adminService.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("{id}")
	public Administration findById(@PathVariable(name = "id") int id) {
		return adminService.findById(id);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("")
	public Administration create(@RequestBody Administration p) {
		adminService.save(p);
		return p;

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("{id}")
	public void delete(@PathVariable(name = "id") int id) {
		adminService.delete(adminService.findById(id));
	}

	@CrossOrigin(origins = "*")
	@PutMapping("")
	public void update(@RequestBody Administration p) {
		adminService.save(p);

	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("{id}/{password}")
	public Administration findByLoginAndPassword(@PathVariable(name = "id") int id, @PathVariable(name = "password") String password){
		return adminService.findByLoginAndPassword(id, password);
	}

}
