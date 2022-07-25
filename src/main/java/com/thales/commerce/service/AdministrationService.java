package com.thales.commerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thales.commerce.model.Administration;
import com.thales.commerce.repo.AdminRepository;

@Service
public class AdministrationService {

	@Autowired
	AdminRepository adminRepo;
	
	public List<Administration> findAll() {

		return adminRepo.findAll();
	}

	public Administration findById(int id) {

		return adminRepo.findById(id).get();
	}

	public void save(Administration c) {
		adminRepo.save(c);

	}

	public void delete(Administration c) {
		adminRepo.delete(c);

	}
	
	public Administration findByLoginAndPassword(int id, String password){
		return adminRepo.findByLoginAndPassword(id, password);
	}
}
