package com.thales.commerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class LigneCommande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantite;
	private double prix;
	@ManyToOne
	private Commande commande;
	@ManyToOne
	private Article article;
	@Version
	private int version;

	public LigneCommande(int quantite, double prix, Article article) {
		super();
		this.quantite = quantite;
		this.prix = prix;
		this.article = article;
	}

	public LigneCommande(int quantite, double prix, Commande commande, Article article) {
		super();
		this.quantite = quantite;
		this.prix = prix;
		this.commande = commande;
		this.article = article;
	}

	public LigneCommande() {
		
		super();
		article=new Article();
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", quantite=" + quantite + ", prix=" + prix + ", article=" + article + "]";
	}

}
