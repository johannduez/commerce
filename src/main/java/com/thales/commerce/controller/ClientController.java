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

import com.thales.commerce.model.Client;
import com.thales.commerce.service.ClientService;
import com.thales.commerce.service.CommandeService;

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientService clientService;

	@CrossOrigin(origins = "*")
	@GetMapping("")
	public List<Client> findAll() {
		return clientService.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("{id}")
	public Client findById(@PathVariable(name = "id") int id) {
		return clientService.findById(id);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("")
	public Client create(@RequestBody Client p) {
		clientService.save(p);
		System.out.println(p);
		return p;

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("{id}")
	public void delete(@PathVariable(name = "id") int id) {
		clientService.delete(clientService.findById(id));
	}

	@CrossOrigin(origins = "*")
	@PutMapping("")
	public void update(@RequestBody Client p) {
		clientService.save(p);

	}

}
