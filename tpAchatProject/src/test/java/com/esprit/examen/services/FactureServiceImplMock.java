package com.esprit.examen.services;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.FactureRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Slf4j
public class FactureServiceImplMock {
	
	
	
	@InjectMocks
	IFactureService FactureService;
	
	
	FactureRepository factureRepository= Mockito.mock(FactureRepository.class);
	
	
	@Test
	public void testAddfacture() throws ParseException {
		
			
			Facture f = new Facture();
		f.setIdFacture(122);
		f.setMontantFacture(5);
		FactureService.addFacture(f);
		when(factureRepository.save(f)).thenReturn(f);
		log.info("facture ajouter avec success");
		
			
			
	}
	
	@Test
	public void testRetrieveAllFacture() throws ParseException {
		List<Facture> listFacture = FactureService.retrieveAllFactures();
		log.info("Nombre facture: " + listFacture.size()+" \n");
		for(int i=0;i<listFacture.size();i++){
			log.info(""+listFacture.get(i).getMontantFacture());
		}
	}
	

}
