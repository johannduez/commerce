package com.thales.commerce.repo;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thales.commerce.model.Article;
import com.thales.commerce.model.Commande;


public interface CommandeRepository extends JpaRepository<Commande, Integer> {
	@Query("select a from Commande a where a.client.id = :id  order by date desc")
	public List<Commande> findByClient(@Param("id") int id);
}
