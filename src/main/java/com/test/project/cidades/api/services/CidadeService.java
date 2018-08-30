package com.test.project.cidades.api.services;

import java.util.Optional;

import com.test.project.cidades.api.entities.Cidade;

public interface CidadeService {
	
	/*
	 * Retorna uma cidade pelo ibge_id
	 * 
	 *  @param ibgeId
	 *  @return Optional<Cidade>
	 */
	Optional<Cidade> buscaPorIbgeId(Long ibgeId);

	/*
	 * Cadastra uma cidade
	 * 
	 *  @param cidade
	 *  @return Cidade
	 */
	Cidade persistir(Cidade cidade);
}
