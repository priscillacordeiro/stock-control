package br.com.qualiti.stockcontrol.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.qualiti.stockcontrol.model.Product;
import br.com.qualiti.stockcontrol.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	
	private ProductService productService;
	
	ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping
	public Product create(@RequestBody Product product) {
		return productService.create(product);
	}
	
	@GetMapping
	public List<Product> getAll() {
		return productService.getAll();
	}
	
	@GetMapping("/{id}")
	public Product getById(@PathVariable Long id) {
		return productService.getById(id);
	}
	
	@GetMapping("/name/{name}")
	public List<Product> getByName(@PathVariable String name) {
		return productService.getByName(name);
	}
	
	@GetMapping("/code/{code}")
	public Product getByCode(@PathVariable Long code) {
		return productService.getByCode(code);
	}
	
	@PutMapping("/{id}")
	public Product update(@PathVariable Long id, Product product) {
		return productService.update(id, product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}

}