package com.thales.commerce.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.thales.commerce.model.Client;



public interface ClientRepository extends JpaRepository<Client, Integer> {
	Client findByIdAndPassword(int id, String password);
}
