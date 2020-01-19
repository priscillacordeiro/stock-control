package br.com.qualiti.stockcontrol.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.qualiti.stockcontrol.model.Gondola;
import br.com.qualiti.stockcontrol.service.GondolaService;

@RestController
@RequestMapping("/api/v1/gondola")
public class GondolaController {
	
	private GondolaService gondolaService;
	
	GondolaController(GondolaService gondolaService) {
		this.gondolaService = gondolaService;
	}
	
	@PostMapping
	public Gondola create(@RequestBody Gondola gondola) {
		return gondolaService.create(gondola);
	}
	
	@GetMapping
	public List<Gondola> getAll() {
		return gondolaService.getAll();
	}

}