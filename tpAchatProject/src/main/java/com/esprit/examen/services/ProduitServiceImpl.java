package com.esprit.examen.services;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProduitServiceImpl implements IProduitService {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	CategorieProduitRepository categorieProduitRepository;

	@Override
	public List<Produit> retrieveAllProduits() {
		
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		
		return produits;
	}

	@Override
	public Produit addProduit(Produit p) {
		
		return produitRepository.save(p);
		 
	}

	

	@Override
	public void deleteProduit(Long produitId) {
	
		produitRepository.deleteById(produitId);
		
	}

	@Override
	public Produit updateProduit(Produit p) {
		return produitRepository.save(p);
	}

	@Override
	public Produit retrieveProduit(Long produitId) {
	
		
		Produit produit = produitRepository.findById(produitId).orElse(null);
		return produit;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit produittmatm = produitRepository.findById(idProduit).orElse(null);
		Stock stockmt3tmatm = stockRepository.findById(idStock).orElse(null);
		produittmatm.setStock(stockmt3tmatm);
		produitRepository.save(produittmatm);

	}


}