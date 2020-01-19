package br.com.qualiti.stockcontrol.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<Gondola> getAll() {
		return gondolaRepository.findAll();
	}

	public Optional<Gondola> getById(Long id) {
		return gondolaRepository.findById(id);
	}
	
}