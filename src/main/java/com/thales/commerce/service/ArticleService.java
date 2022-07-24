package com.thales.commerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thales.commerce.model.Article;
import com.thales.commerce.repo.ArticleRepository;

@Service
public class ArticleService {
	@Autowired
	ArticleRepository articleRepo;

	public List<Article> findAll() {

		return articleRepo.findAll();
	}

	public Article findById(int id) {

		return articleRepo.findById(id).get();
	}

	public void save(Article p) {
		articleRepo.save(p);

	}

	public void delete(Article article) {
		articleRepo.delete(article);

	}
	public List<Article> findByOrderByTarifAsc(){
		return articleRepo.findByOrderByTarifAsc();
	}

	public List<Article> findFiltreTotal(String tel, String ordi, String elec, Double prixMax, Double prixMin,
			String leNom) {
		String nom = "%";
		if (!leNom.isEmpty() && !leNom.equals("")) {
			nom += leNom + "%";
		}
		double prixMi = prixMin != null ? prixMin : 0;
		double prixMa = prixMax != null ? prixMax : 100000000;
		String nomTel = "";
		String nomOrdi = "";
		String nomElec = "";
		if (tel.equals("1"))
			nomTel = "Téléphone";
		if (ordi.equals("1"))
			nomOrdi = "Ordinateur";
		if (elec.equals("1"))
			nomElec = "Electroménager";
		return articleRepo.findFiltreTotal(nomTel, nomOrdi, nomElec, prixMa, prixMi, nom);
	}

}
