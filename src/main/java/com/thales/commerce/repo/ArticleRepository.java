package com.thales.commerce.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thales.commerce.model.Article;


public interface ArticleRepository extends JpaRepository<Article, Integer> {
	public List<Article> findByCategorieOrderByTarif(String categorie);

	public Article findByNom(String nom);
	
	public List<Article> findByOrderByTarifAsc();
	
	@Query("select a from Article a where a.categorie = :laCategorie and tarif <= :prixMax and tarif >= :prixMin and nom like :leNom order by tarif")
	public List<Article> findFiltre(@Param("laCategorie") String laCategorie,
			@Param("prixMax") double prixMax,@Param("prixMin") double prixMin,@Param("leNom") String leNom);
	
	@Query("select a from Article a where (a.categorie = :tel or a.categorie = :ordi  or a.categorie = :elec ) and tarif <= :prixMax and tarif >= :prixMin and nom like :leNom order by tarif")
	public List<Article> findFiltreTotal(@Param("tel") String tel,@Param("ordi") String ordi,@Param("elec") String elec,
			@Param("prixMax") double prixMax,@Param("prixMin") double prixMin,@Param("leNom") String leNom);
}
