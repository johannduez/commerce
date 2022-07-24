package com.thales.commerce.repo;




import org.springframework.data.jpa.repository.JpaRepository;

import com.thales.commerce.model.LigneCommande;




public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer> {
	
}
