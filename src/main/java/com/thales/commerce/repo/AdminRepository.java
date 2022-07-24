package com.thales.commerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thales.commerce.model.Administration;




public interface AdminRepository extends JpaRepository<Administration, Integer> {
	Administration findByLoginAndPassword(int login, String password);
}
