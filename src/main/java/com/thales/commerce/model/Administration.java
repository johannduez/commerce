package com.thales.commerce.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Administration {
	@Id
	private int login;
	private String password;
	private int actif;
	@Version
	private int version;

	public Administration(int login, String password, int actif) {
		super();
		this.login = login;
		this.password = password;
		this.actif = actif;
	}

	public Administration() {
		super();
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActif() {
		return actif;
	}

	public void setActif(int actif) {
		this.actif = actif;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Admin [login=" + login + ", password=" + password + ", actif=" + actif + "]";
	}

}
