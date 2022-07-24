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

import com.thales.commerce.model.Commande;
import com.thales.commerce.service.CommandeService;

@RestController
@RequestMapping("/commande")
public class CommandeController {
	@Autowired
	private CommandeService commandeService;

	@CrossOrigin()
	@GetMapping("")
	public List<Commande> findAll() {
		return commandeService.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("{id}")
	public Commande findById(@PathVariable(name = "id") int id) {
		return commandeService.findById(id);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("")
	public Commande create(@RequestBody Commande p) {
		commandeService.save(p);
		System.out.println(p);
		return p;

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("{id}")
	public void delete(@PathVariable(name = "id") int id) {
		commandeService.delete(commandeService.findById(id));
	}

	@CrossOrigin(origins = "*")
	@PutMapping("")
	public void update(@RequestBody Commande p) {
		commandeService.save(p);

	}

}
