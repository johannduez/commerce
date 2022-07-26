package com.thales.commerce.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.thales.commerce.model.Article;
import com.thales.commerce.repo.ArticleRepository;

@Service
public class ArticleService {
	@Autowired
	ArticleRepository articleRepo;

	public List<Article> findAll() {

		List<Article> list = articleRepo.findAll();
		for (Article art : list) {
			if (art.getPicByte() != null)
				art.setPicByte(decompressBytes(art.getPicByte()));
		}

		return list;
	}

	public Article findById(int id) {
		Article art = articleRepo.findById(id).get();
		if (art.getPicByte() != null)
			art.setPicByte(decompressBytes(art.getPicByte()));
		return art;
	}

	public void save(MultipartFile file, String id, String categorie, String description, String nom, String tarif,
			String version) {
		Article p = new Article(nom, description, Double.parseDouble(tarif), file.getOriginalFilename(), categorie);
		p.setId(Integer.parseInt(id));
		p.setVersion(Integer.parseInt(version));
		try {
			p.setPicByte(compressBytes(file.getBytes()));
		} catch (IOException e) {

			e.printStackTrace();
		}
		this.save(p);

	}

	public void save(Article p) {

		articleRepo.save(p);

	}

	public void delete(Article article) {
		articleRepo.delete(article);

	}

	public List<Article> findByOrderByTarifAsc() {
		List<Article> list = articleRepo.findByOrderByTarifAsc();
		for (Article art : list) {
			if (art.getPicByte() != null)
				art.setPicByte(decompressBytes(art.getPicByte()));
		}

		return list;
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
		List<Article> list = articleRepo.findFiltreTotal(nomTel, nomOrdi, nomElec, prixMa, prixMi, nom);
		for (Article art : list) {
			if (art.getPicByte() != null)
				art.setPicByte(decompressBytes(art.getPicByte()));
		}

		return list;
	}

	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

}
