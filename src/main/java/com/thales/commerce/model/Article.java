package com.thales.commerce.model;

import java.util.ArrayList;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import com.fasterxml.jackson.annotation.JsonView;



@Entity
public class Article implements Comparable<Article> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Common.class)
	private int id;
	@JsonView(JsonViews.Common.class)
	private String nom;
	@JsonView(JsonViews.Common.class)
	private String description;
	
	@JsonView(JsonViews.Common.class)
	private double tarif;
	@JsonView(JsonViews.Common.class)
	private String image;
	@JsonView(JsonViews.Common.class)
	private String categorie;
	@OneToMany(mappedBy = "article")
	@JsonView(JsonViews.LigneCommandeWithArticle.class)
	private Collection<LigneCommande> lignes = new ArrayList<LigneCommande>();
	@Version
	@JsonView(JsonViews.Common.class)
	private int version;

	/*@Transient
	private MultipartFile multiPartFile;*/

	public Article(String nom, String description, double tarif, String image, String categorie) {
		super();
		this.nom = nom;
		this.description = description;
		this.tarif = tarif;
		this.image = image;
		this.categorie = categorie;
	}

	public Article() {
		super();
	}

	public String getNom() {
		return nom;
	}

	/*public MultipartFile getMultiPartFile() {
		return multiPartFile;
	}

	public void setMultiPartFile(MultipartFile multiPartFile) {
		this.multiPartFile = multiPartFile;
	}*/

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<LigneCommande> getLignes() {
		return lignes;
	}

	public void setLignes(Collection<LigneCommande> lignes) {
		this.lignes = lignes;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", description=" + description + ", tarif=" + tarif + ", image="
				+ image + ", categorie=" + categorie + "]";
	}

	@Override
	public int compareTo(Article arg0) {
		if (this.tarif > arg0.tarif)
			return 1;
		if (this.tarif < arg0.tarif)
			return -1;
		return 0;
	}

}
