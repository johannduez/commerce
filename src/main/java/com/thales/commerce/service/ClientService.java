package com.thales.commerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thales.commerce.model.Client;
import com.thales.commerce.repo.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepo;
	
	public List<Client> findAll() {

		return clientRepo.findAll();
	}

	public Client findById(int id) {

		return clientRepo.findById(id).get();
	}

	public void save(Client c) {
		clientRepo.save(c);

	}

	public void delete(Client c) {
		clientRepo.delete(c);

	}
	
	public Client findByIdAndPassword(int id, String password){
		return clientRepo.findByIdAndPassword(id, password);
	}
}
