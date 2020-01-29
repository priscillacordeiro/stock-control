package br.com.qualiti.stockcontrol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.qualiti.stockcontrol.exception.ResourceAlreadyExistsException;
import br.com.qualiti.stockcontrol.exception.ResourceNotFoundException;
import br.com.qualiti.stockcontrol.model.Gondola;
import br.com.qualiti.stockcontrol.model.Product;
import br.com.qualiti.stockcontrol.repository.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository productRepository;
	
	ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository; 
	}
	
	public List<Product> getAll() {
		return productRepository.findAll();
	}
	
	public Product getById(long id) {
		return productRepository.findById(id).get();
	}
	
	public List<Product> getByName(String name) {
		return productRepository.findByNameContaining(name);
	}
	
	public Product create(Product product) {
		Product currentProduct = productRepository.findByCode(product.getCode());
		if(currentProduct == null) {
			return productRepository.save(product);
		} else {
			throw new ResourceAlreadyExistsException("Product");
		}	
	}
	
	public Product update(long id, Product product) {
		Optional<Product> currentProduct = productRepository.findById(id);
		if(currentProduct.isPresent()) {
			currentProduct.get().setName(product.getName());
			currentProduct.get().setCode(product.getCode());
			currentProduct.get().setQuantity(product.getQuantity());
			currentProduct.get().setUnitPrice(product.getUnitPrice());
			return productRepository.save(currentProduct.get());
		} else {
			throw new ResourceNotFoundException("Product", "Client", "with id: " + id + " not found");
		}
	}
	
	public void delete(long id) {
		productRepository.deleteById(id);
	}	

}