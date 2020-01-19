package br.com.qualiti.stockcontrol.service;

import org.springframework.stereotype.Service;

import br.com.qualiti.stockcontrol.model.Gondola;
import br.com.qualiti.stockcontrol.repository.GondolaRepository;

@Service
public class GondolaService {

	private GondolaRepository gondolaRepository;
	
	GondolaService(GondolaRepository gondolaRepository) {
		this.gondolaRepository = gondolaRepository;
	}
	
	public Gondola create(Gondola gondola) {
		return gondolaRepository.save(gondola);
	}
	
}
