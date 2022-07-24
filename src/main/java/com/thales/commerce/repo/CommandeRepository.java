package com.thales.commerce.repo;




import org.springframework.data.jpa.repository.JpaRepository;

import com.thales.commerce.model.Commande;


public interface CommandeRepository extends JpaRepository<Commande, Integer> {
	
}
