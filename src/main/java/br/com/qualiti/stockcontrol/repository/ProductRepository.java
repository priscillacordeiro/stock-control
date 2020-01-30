package br.com.qualiti.stockcontrol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.qualiti.stockcontrol.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByNameContaining(String name);

	Product findByCode(Long code);
	
	List<Product> findByQuantityEquals(long quantity);

}