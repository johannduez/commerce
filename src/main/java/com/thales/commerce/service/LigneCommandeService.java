package com.thales.commerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thales.commerce.model.LigneCommande;
import com.thales.commerce.repo.LigneCommandeRepository;

@Service
public class LigneCommandeService {
	@Autowired
	LigneCommandeRepository ligneRepo;

	public List<LigneCommande> findAll() {

		return ligneRepo.findAll();
	}

	public LigneCommande findById(int id) {

		return ligneRepo.findById(id).get();
	}

	public void save(LigneCommande p) {
		ligneRepo.save(p);

	}

	public void delete(LigneCommande article) {
		ligneRepo.delete(article);

	}

}
