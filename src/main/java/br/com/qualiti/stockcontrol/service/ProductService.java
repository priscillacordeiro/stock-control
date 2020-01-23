package br.com.qualiti.stockcontrol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.qualiti.stockcontrol.exception.ResourceNotFoundException;
import br.com.qualiti.stockcontrol.model.Product;
import br.com.qualiti.stockcontrol.repository.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository productRepository;
	
	ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository; 
	}
	
	// Method to create and save a product on repository, requires product body.
	public Product create(Product product) {
		return productRepository.save(product);
	}
	
	// Method to delete a product from repository, requires product id. SEARCH IF THIS METHOD THROWS AN EXCEPTION
	public void delete(long id) {
			productRepository.deleteById(id);
	}
	
	// Method to find all the products on repository, returns a list of them.
	public List<Product> getAll() {
		return productRepository.findAll();
	}
	
	// Method to find a product by the id.
	public Product getById(long id) {
		return productRepository.findById(id).get();
	}
	
	// Method to find by product's name.
	public List<Product> getByName(String name) {
		return productRepository.findByNameContaining(name);
	}

	// MISSING UPDATE: LIST OF GONDOLAS
	public Product update(long id, Product product) {
		Optional<Product> currentProduct = productRepository.findById(id);
		if(currentProduct.isPresent()) {
			currentProduct.get().setName(product.getName());
			currentProduct.get().setCode(product.getCode());
			currentProduct.get().setQuantity(product.getQuantity());
			currentProduct.get().setUnitPrice(product.getUnitPrice());
			return productRepository.save(currentProduct.get());
		} else {
			throw new ResourceNotFoundException("Product", "Client", "O id: " + id + "não foi encontrado.");
		}
	}
}