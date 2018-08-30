package com.test.project.cidades.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.test.project.cidades.api.entities.Cidade;
import com.test.project.cidades.api.repositories.CidadeRepository;
import com.test.project.cidades.api.services.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService{
	
	//private static final Logger log = LoggerFactory.getLogger(CidadeServiceImpl.class);
	
	@Autowired 
	private CidadeRepository cidadeRepository;
	
	@Override
	public Optional<Cidade> buscaPorIbgeId(Long ibgeId){
		return Optional.ofNullable(cidadeRepository.findByIbgeId(ibgeId));
	}
	
	@Override
	public Cidade persistir(Cidade cidade) {
		return this.cidadeRepository.save(cidade);
	}

}
