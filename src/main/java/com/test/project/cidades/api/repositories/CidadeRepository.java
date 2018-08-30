package com.test.project.cidades.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.project.cidades.api.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	Cidade findByIbgeId(Long ibgeId);
	
}
