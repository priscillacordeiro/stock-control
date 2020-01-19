package br.com.qualiti.stockcontrol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Gondola {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Long street;
	
	@Column(nullable = false)
	private Long section;
	
	@Column(nullable = false)
	private Long shelf;
	
	public Gondola() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getStreet() {
		return street;
	}
	
	public void setStreet(Long street) {
		this.street = street;
	}
	
	public Long getSection() {
		return section;
	}
	
	public void setSection(Long section) {
		this.section = section;
	}
	
	public Long getShelf() {
		return shelf;
	}
	
	public void setShelf(Long shelf) {
		this.shelf = shelf;
	}
	
}