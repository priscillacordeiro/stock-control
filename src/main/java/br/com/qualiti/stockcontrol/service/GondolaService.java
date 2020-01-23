package br.com.qualiti.stockcontrol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.qualiti.stockcontrol.exception.ResourceAlreadyExistsException;
import br.com.qualiti.stockcontrol.exception.ResourceNotFoundException;
import br.com.qualiti.stockcontrol.model.Gondola;
import br.com.qualiti.stockcontrol.repository.GondolaRepository;

@Service
public class GondolaService {

	private GondolaRepository gondolaRepository;
	
	GondolaService(GondolaRepository gondolaRepository) {
		this.gondolaRepository = gondolaRepository;
	}
	
	public Gondola create(Gondola gondola) {
		Gondola currentGondola = gondolaRepository.findByStreetAndSectionAndShelf(gondola.getStreet(), gondola.getSection(), gondola.getShelf());
		if(currentGondola == null) {
			return gondolaRepository.save(gondola);
		} else {
			throw new ResourceAlreadyExistsException("Gondola");
		}
	}
	
	public List<Gondola> getAll() {
		return gondolaRepository.findAll();
	}

	public Gondola getById(Long id) {
		Optional<Gondola> gondola = gondolaRepository.findById(id);
		if(gondola.isPresent()) {
			return gondola.get();
		} else {
			throw new ResourceNotFoundException("Gondola", "Gondola", "Gondola with id: " + id + " not found");
		}
	}
	
	public Gondola update(Long id, Gondola gondola) {
		Optional<Gondola> currentGondola = gondolaRepository.findById(id);
		if(currentGondola.isPresent()) {
			currentGondola.get().setStreet(gondola.getStreet());
			currentGondola.get().setSection(gondola.getSection());
			currentGondola.get().setShelf(gondola.getShelf());
			return gondolaRepository.save(currentGondola.get());
		} else {
			throw new ResourceNotFoundException("Gondola", "Gondola", "Gondola with id: " + id + " not found");
		}
	}
	
	public void delete(Long id) {
		Optional<Gondola> gondola = gondolaRepository.findById(id);
		if(gondola.isPresent()) {
			gondolaRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Gondola", "Gondola", "Gondola with id: " + id + " not found");
		}
	}
	
}