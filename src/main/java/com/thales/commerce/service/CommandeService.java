package com.thales.commerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thales.commerce.model.Client;
import com.thales.commerce.model.Commande;
import com.thales.commerce.repo.CommandeRepository;

@Service
public class CommandeService {
	@Autowired
	CommandeRepository commandeRepo;

	public List<Commande> findAll() {

		return commandeRepo.findAll();
	}

	public Commande findById(int id) {

		return commandeRepo.findById(id).get();
	}

	public void save(Commande p) {
		commandeRepo.save(p);

	}

	public void delete(Commande article) {
		commandeRepo.delete(article);

	}
	
	public List<Commande> findByClient_idByOrderByDateDesc(Integer id){
		
		return commandeRepo.findByClient_idByOrderByDateDesc(id);
	}

}
