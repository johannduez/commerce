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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.thales.commerce.model.Article;
import com.thales.commerce.model.JsonViews;
import com.thales.commerce.service.ArticleService;


@RestController
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	@CrossOrigin()
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Article> findAll() {
		
		
		
		/*test*/
//		Article art1 = new Article("Smartphone Apple iPhone 13",
//				"Ecran OLED Super Retina XDR de 15,5 cm Mémoire de stockage : 512 Go", 799, "assets/img/tel1.png",
//				"Téléphone");
//		articleService.save(art1);
//		Article art2 = new Article("Smartphone XIAOMI",
//				"XIAOMI PACK REDMINOTE 10 128GO GRIS 5G + BRACELET CONNECTÉ MI SMART BAND 5", 219,
//				"assets/img/xiaomi.jpg", "Téléphone");
//		articleService.save(art2);
//		Article art3 = new Article("Smartphone SAMSUNG GALAXY S22", "OS Android 12 - 256Go de ROM, 12Go de RAM", 499,
//				"assets/img/tel2.jpg", "Téléphone");
//		articleService.save(art3);
//		Article art4 = new Article("Smartphone OPPO RENO", "OS Android 11 -128Go de ROM, 8Go de RAM", 219,
//				"assets/img/tel3.jpg", "Téléphone");
//		articleService.save(art4);
//
//		Article art5 = new Article("PC portable LENOVO IDEAPAD 3",
//				"Processeur Intel Core™ i5-1135G7 (4 coeurs, 2,4 GHz / Turbo Boost jusqu'à 4,2 GHz)", 499,
//				"assets/img/ordi1.webp", "Ordinateur");
//		articleService.save(art5);
//		Article art6 = new Article("PC portable DELL INSPIRON",
//				"Processeur Intel Core™ i7-1255U (10 coeurs, 1,7 GHz / Turbo Boost jusqu'à 4,7GHz)", 959,
//				"assets/img/ordi2.png", "Ordinateur");
//		articleService.save(art6);
//		Article art7 = new Article("PC portable MSI MODERN",
//				" Processeur Intel Core™ i7-1195G7 (4 coeurs, 2.9 GHz / Turbo Boost jusqu'à 5 GHz)", 879,
//				"assets/img/ordi3.png", "Ordinateur");
//		articleService.save(art7);
//		Article art8 = new Article("PC portable LENOVO IDEAPAD 5",
//				"Proceseur AMD Ryzen™ 9 5900HX (8 coeurs, 3,3 GHz Turbo Boost)", 959, "assets/img/ordi4.webp",
//				"Ordinateur");
//		articleService.save(art8);
//
//		Article art9 = new Article("Lave-linge hublot SAMSUNG", "Capacité 9kg (tambour 61 L) - Classe énergétique A",
//				499, "assets/img/electro1.jpg", "Electroménager");
//		articleService.save(art9);
//		Article art10 = new Article("Lave-linge séchant WHIRLPOOL",
//				"Capacité de lavage 9kg / séchage 7kg - Classe énergétique E", 579, "assets/img/electro2.jpg",
//				"Electroménager");
//		articleService.save(art10);
//		Article art11 = new Article("Lave-vaisselle THOMSON", "Largeur 60 cm (14 couverts) - 47dB (classe sonore C)",
//				399, "assets/img/electro3.png", "Electroménager");
//		articleService.save(art11);
//		Article art12 = new Article("Lave-vaisselle THOMSON ENCASTRABLE",
//				"Encastrable - Largeur 60 cm (14 couverts) - 44dB", 399, "assets/img/electro4.jpg", "Electroménager");
//		articleService.save(art12);
		return articleService.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("{id}")
	@JsonView(JsonViews.Common.class)
	public Article findById(@PathVariable(name = "id") int id) {
		return articleService.findById(id);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("")
	public void create(@RequestParam("imageFile") MultipartFile file,@RequestParam("id") String id,
			@RequestParam("categorie") String categorie,@RequestParam("description") String description,
			@RequestParam("nom") String nom,@RequestParam("tarif") String tarif,@RequestParam("version") String version) {
		articleService.save(file,id,categorie,description,nom,tarif,version);
		
		
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("{id}")
	public void delete(@PathVariable(name = "id") int id) {
		articleService.delete(articleService.findById(id));
	}

	/*@CrossOrigin(origins = "*")
	@PutMapping("")
	public void update(@RequestBody Article p) {
		articleService.save(p);

	}
	*/
	@CrossOrigin(origins = "*")
	@PutMapping("")
	public void update(@RequestParam(value = "imageFile", required = false) MultipartFile file,@RequestParam("id") String id,
			@RequestParam("categorie") String categorie,@RequestParam("description") String description,
			@RequestParam("nom") String nom,@RequestParam("tarif") String tarif,
			@RequestParam("version") String version) {
		
		articleService.save(file,id,categorie,description,nom,tarif,version);
		
		
	}
      
	@CrossOrigin()
	@GetMapping("findbyorderbytarifasc")
	@JsonView(JsonViews.Common.class)
	public List<Article> findByOrderByTarifAsc(){
		return articleService.findByOrderByTarifAsc();
	}
	@CrossOrigin(origins = "*")
	@GetMapping("findfiltretotal/{tel}/{ordi}/{elec}/{prixMax}/{prixMin}/{leNom}")
	@JsonView(JsonViews.Common.class)
	public List<Article> findFiltreTotal(@PathVariable(name = "tel")String tel,
			@PathVariable(name = "ordi") String ordi,
			@PathVariable(name = "elec")String elec, 
			@PathVariable(name = "prixMax")Double prixMax,
			@PathVariable(name = "prixMin")Double prixMin,
			@PathVariable(name = "leNom")String leNom
			) {
		return articleService.findFiltreTotal(tel, ordi, elec, prixMax, prixMin, leNom);
	}
	@CrossOrigin(origins = "*")
	@GetMapping("findfiltretotal/{tel}/{ordi}/{elec}/{prixMax}/{prixMin}")
	@JsonView(JsonViews.Common.class)
	public List<Article> findFiltreTotal(@PathVariable(name = "tel")String tel,
			@PathVariable(name = "ordi") String ordi,
			@PathVariable(name = "elec")String elec, 
			@PathVariable(name = "prixMax")Double prixMax,
			@PathVariable(name = "prixMin")Double prixMin
			) {
		return articleService.findFiltreTotal(tel, ordi, elec, prixMax, prixMin, "");
	}
	
	
}
