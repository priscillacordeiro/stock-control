package br.com.qualiti.stockcontrol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 30, nullable = false)
	private String name;
	
	@Column(length = 10, nullable = false, unique = true)
	private Long code;
	
	@Column(nullable = true)
	private Long quantity;
	
	@Column(nullable = false)
	private Double unitPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gondola_id", nullable = false)
	private Gondola gondola;
	
	public Product() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Gondola getGondola() {
		return gondola;
	}

	public void setGondola(Gondola gondola) {
		this.gondola = gondola;
	}

}