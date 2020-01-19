package br.com.qualiti.stockcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.qualiti.stockcontrol.model.Gondola;

@Repository
public interface GondolaRepository extends JpaRepository<Gondola, Long> {
}