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

import com.fasterxml.jackson.annotation.JsonView;
import com.thales.commerce.model.JsonViews;
import com.thales.commerce.model.LigneCommande;
import com.thales.commerce.service.LigneCommandeService;

@RestController
@RequestMapping("/lignecommande")
public class LigneCommandeController {
	@Autowired
	private LigneCommandeService ligneService;

	@CrossOrigin()
	@GetMapping("")
	@JsonView(JsonViews.CommandeArticleWithLigneCommande.class)
	public List<LigneCommande> findAll() {
		return ligneService.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("{id}")
	@JsonView(JsonViews.CommandeArticleWithLigneCommande.class)
	public LigneCommande findById(@PathVariable(name = "id") int id) {
		return ligneService.findById(id);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("")
	public void create(@RequestBody LigneCommande p) {
		ligneService.save(p);

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("{id}")
	public void delete(@PathVariable(name = "id") int id) {
		ligneService.delete(ligneService.findById(id));
	}

	@CrossOrigin(origins = "*")
	@PutMapping("")
	public void update(@RequestBody LigneCommande p) {
		ligneService.save(p);

	}

}
