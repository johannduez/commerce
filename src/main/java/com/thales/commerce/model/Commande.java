package com.thales.commerce.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Client client;
	private Date date;
	private double prixTotal;
	@OneToMany(mappedBy = "commande")
	@JsonIgnore
	private List<LigneCommande> lignes = new ArrayList<LigneCommande>();
	@Version
	private int version;
	public Commande() {
		super();
		long miliseconds = System.currentTimeMillis();
		date = new Date(miliseconds);
	}
	
	public Commande( Date date, double prixTotal, String infos) {
		this.date = date;
		this.prixTotal = prixTotal;
		
	}

	public void addLigneCommande(int idArticle, int quantite, List<Article> articles) {
		boolean isTrouve = false;
		for (LigneCommande ligne : lignes) {
			if (ligne.getArticle().getId() == idArticle) {
				isTrouve = true;
				ligne.setQuantite(ligne.getQuantite() + quantite);
				ligne.setPrix(ligne.getQuantite() * ligne.getArticle().getTarif());
				this.prixTotal += quantite * ligne.getArticle().getTarif();
				break;
			}
		}
		if (!isTrouve) {
			Article article = null;
			for (Article art : articles) {
				if (art.getId() == idArticle) {
					article = art;
					break;
				}
			}
			if (article != null) {
				lignes.add(new LigneCommande(quantite, quantite * article.getTarif(),this, article));
				this.prixTotal += quantite * article.getTarif();
			}
		}

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public List<LigneCommande> getLignes() {
		return lignes;
	}

	public void setLignes(List<LigneCommande> lignes) {
		this.lignes = lignes;
	}

	public void add(LigneCommande ligne) {
		this.lignes.add(ligne);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", client=" + client + ", date=" + date + ", prixTotal=" + prixTotal
				+ ", version=" + version + "]";
	}





}
